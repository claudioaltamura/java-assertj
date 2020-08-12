package de.claudioaltamura.java.assertj;

import java.util.ArrayList;
import java.util.List;

class TestDataProvider {

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
