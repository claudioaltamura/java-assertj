package de.claudioaltamura.java.assertj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarFleet {

  private List<Car> fleet = new ArrayList<>();

  public List<Car> getFleet() {
    return Collections.unmodifiableList(fleet);
  }

  public void add(Car car) {
    this.fleet.add(car);
  }
}
