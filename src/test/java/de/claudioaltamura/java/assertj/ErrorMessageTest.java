package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

  @Test
  void testWithFailMessage() {
    Car bmw = new Car();
    bmw.setName("Bmw");
    List<Car> cars = List.of(bmw);

    assertThat(cars).withFailMessage("should contains a car '%s'", bmw.getName()).contains(bmw);
  }
}
