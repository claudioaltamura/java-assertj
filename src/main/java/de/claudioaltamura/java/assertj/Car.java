
package de.claudioaltamura.java.assertj;

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

  public void explode() throws Exception {
    throw new Exception("boom!");
  }
  
  @Override
  public String toString() {
    return "Car [name=" + name + ", wheels=" + wheels + ", color=" + color + ", type=" + type + "]";
  }

}
