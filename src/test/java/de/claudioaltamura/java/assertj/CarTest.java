package de.claudioaltamura.java.assertj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void test() {
    Car car = new Car();
    car.setWheels(4);

    assertEquals(car.getWheels(),4);
  }

}
