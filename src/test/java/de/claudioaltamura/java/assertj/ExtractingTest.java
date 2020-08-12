package de.claudioaltamura.java.assertj;

import static de.claudioaltamura.java.assertj.TestDataProvider.createCarList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExtractingTest {

  @Test
  void testExtracting() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("BMW");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);

    assertThat(cars).extracting(Car::getName).doesNotContain("VW");
  }

  @Test
  void testExtractWithTuple() {
    List<Car> cars = new ArrayList<>();

    Car bmw = new Car();
    bmw.setName("BMW");
    bmw.setColor("white");
    cars.add(bmw);

    assertThat(cars).extracting("name", "color").contains(tuple("BMW", "white"));
  }

  @Test
  void testFlatMapExtracting() {
    Car bmw = new Car();
    bmw.setName("BMW");
    bmw.setColor("white");

    CarFleet fleet = new CarFleet();
    fleet.add(bmw);

    List<CarFleet> fleets = new ArrayList<>();
    fleets.add(fleet);

    assertThat(fleets).flatExtracting(input -> input.getFleet()).contains(bmw);
  }

  @Test
  void testExtractingResultOf() {
    List<Car> cars = createCarList();
    assertThat(cars)
        .extractingResultOf("getColor")
        .contains("white", "black", "red")
        .doesNotContain("blue");
  }
}
