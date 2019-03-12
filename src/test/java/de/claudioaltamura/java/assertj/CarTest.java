package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void testIsEqual() {
    Car car = new Car();
    car.setWheels(4);

    assertThat(car.getWheels()).isEqualTo(4);
  }

  @Test
  void testStartsWith() {
    Car car = new Car();
    car.setName("BMW");

    assertThat(car.getName()).startsWith("B");
  }

  @Test
  void testHasSize() {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car());
    cars.add(new Car());

    assertThat(cars).hasSize(2);
  }

  @Test
  void testContains() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("Bmw");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);

    assertThat(cars).contains(bmw, mercedes);
  }

  @Test
  void testAs() {
    Car bot = new Car();
    bot.setWheels(3);

    assertThat(bot.getWheels()).as("check wheels", bot.getWheels()).isEqualTo(3);
  }

  @Test
  void testException() {
    Car oldCar = new Car();
    Throwable thrown = catchThrowable(() -> oldCar.explode());
    assertThat(thrown).hasMessage("boom!");
  }

  @Test
  void test() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("BMW");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);

    assertThat(cars).extracting(Car::getName).doesNotContain("VW");
  }

}
