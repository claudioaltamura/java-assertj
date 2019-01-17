package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void test() {
    Car car = new Car();
    car.setWheels(4);

    assertThat(car.getWheels()).isEqualTo(4);
  }

}
