package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

  @Test
  void testException() {
    Car oldCar = new Car();
    Throwable thrown = catchThrowable(oldCar::explode);
    assertThat(thrown).isInstanceOf(Exception.class).hasMessage("boom!");
  }

  @Test
  void testDoesNotThrowAnyException() {
    Car car = new Car();
    assertThatCode(car::hoot).doesNotThrowAnyException();
  }

  @Test
  void testAssertThatThrownBy() {
    Car oldCar = new Car();
    assertThatThrownBy(oldCar::explode).isInstanceOf(Exception.class).hasMessageContaining("boom");
  }

  @Test
  void testAssertThatExceptionOfType() {
    Car oldCar = new Car();
    assertThatExceptionOfType(Exception.class).isThrownBy(oldCar::explode);
  }
}
