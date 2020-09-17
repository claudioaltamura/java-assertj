package de.claudioaltamura.java.assertj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class TestDataProvider {

  static Map<String, Car> createCarMap() {
    return createCarList().stream().collect(Collectors.toMap(Car::getName, Function.identity()));
  }

  static List<Car> createCarList() {
    List<Car> cars = new ArrayList<>();

    Car bmw = new Car();
    bmw.setName("BMW");
    bmw.setColor("white");
    cars.add(bmw);
    Car mercedes = new Car();
    mercedes.setName("Mercedes");
    mercedes.setColor("black");
    cars.add(mercedes);
    Car vw = new Car();
    vw.setName("Ferrari");
    vw.setColor("red");
    cars.add(vw);

    return cars;
  }
}
