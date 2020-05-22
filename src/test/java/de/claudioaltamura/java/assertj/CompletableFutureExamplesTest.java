package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class CompletableFutureExamplesTest {

  @Test
  void completed() {
    CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("something");

    assertThat(completedFuture)
        .isCompleted()
        .isCompletedWithValue("something")
        .isCompletedWithValueMatching(result -> result.startsWith("some"))
        .isDone();
  }

  @Test
  void exceptionally() {
    CompletableFuture<?> futureExplosion = new CompletableFuture<>();

    futureExplosion.completeExceptionally(new RuntimeException("boom !"));

    assertThat(futureExplosion).isCompletedExceptionally().isDone();
  }

  @Test
  void failed() {
    CompletableFuture<?> futureExplosion = new CompletableFuture<>();
    futureExplosion.completeExceptionally(new RuntimeException("boom !"));

    assertThat(futureExplosion)
        .hasFailed()
        .hasFailedWithThrowableThat()
        .isInstanceOf(RuntimeException.class)
        .hasMessage("boom !");
  }

  @Test
  void canceled() {
    CompletableFuture<?> cancelledFuture = new CompletableFuture<>();
    cancelledFuture.cancel(true);

    assertThat(cancelledFuture).isCancelled().isDone().isCompletedExceptionally().hasNotFailed();
  }

  @Test
  void succeeded() {
    CompletableFuture<String> future = CompletableFuture.completedFuture("ook!");

    assertThat(future).succeedsWithin(100, TimeUnit.MILLISECONDS).isEqualTo("ook!");
  }
}
