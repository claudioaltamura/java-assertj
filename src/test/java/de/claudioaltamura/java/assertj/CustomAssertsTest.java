package de.claudioaltamura.java.assertj;

import static de.claudioaltamura.java.assertj.CustomAssertions.*;

import org.junit.jupiter.api.Test;

class CustomAssertsTest {

  @Test
  void shouldHave4Wheels() {
    Car car = new Car();
    car.setWheels(4);
    assertThat(car).hasFourWheels();
  }

  @Test
  void shouldHaveAName() {
    Car car = new Car();
    car.setName("Car");
    assertThat(car).hasName();
  }
}
