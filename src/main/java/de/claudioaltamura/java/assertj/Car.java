package de.claudioaltamura.java.assertj;

import java.util.Objects;

public class Car {

  private String name;

  private int wheels;

  private String color;

  private String type;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWheels() {
    return wheels;
  }

  public void setWheels(int wheels) {
    this.wheels = wheels;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void hoot() {
    System.out.println("hoot hoot");
  }

  public void explode() throws Exception {
    throw new Exception("boom!");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return wheels == car.wheels &&
            Objects.equals(name, car.name) &&
            Objects.equals(color, car.color) &&
            Objects.equals(type, car.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, wheels, color, type);
  }

  @Override
  public String toString() {
    return "Car [name=" + name + ", wheels=" + wheels + ", color=" + color + ", type=" + type + "]";
  }
}
