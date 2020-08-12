package de.claudioaltamura.java.assertj;

import static de.claudioaltamura.java.assertj.TestDataProvider.createCarList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class FilterTest {

  @Test
  void testFiltering() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("BMW");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);
    Car vw = new Car();
    vw.setName("VW");
    cars.add(vw);

    assertThat(cars).filteredOn(car -> car.getName().contains("W")).contains(bmw, vw);
  }

  @Test
  void testFilteringAndExtracting() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("BMW");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);
    Car vw = new Car();
    vw.setName("VW");
    cars.add(vw);

    assertThat(cars)
        .filteredOn(car -> car.getName().contains("W"))
        .extracting(Car::getName)
        .contains("BMW", "VW");
  }

  @Test
  void testFilterWithCondition() {
    List<Car> cars = new ArrayList<>();
    Car bmw = new Car();
    bmw.setName("BMW");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    cars.add(mercedes);

    Condition<Car> bmwCondition =
        new Condition<Car>() {
          @Override
          public boolean matches(Car car) {
            return "BMW".equals(car.getName());
          }
        };
    assertThat(cars).filteredOn(bmwCondition).containsOnly(bmw);
  }

  @Test
  void testFilterOnProperty() {
    List<Car> cars = createCarList();

    assertThat(cars).filteredOn("name", "BMW").size().isEqualTo(1);
  }
}
