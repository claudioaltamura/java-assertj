package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

  @Test
  void testException() {
    Car oldCar = new Car();
    Throwable thrown = catchThrowable(() -> oldCar.explode());
    assertThat(thrown).hasMessage("boom!");
  }

  @Test
  public void testDoesNotThrowAnyException() {
    Car car = new Car();
    assertThatCode(
            () -> {
              car.hoot();
            })
        .doesNotThrowAnyException();
  }
}
