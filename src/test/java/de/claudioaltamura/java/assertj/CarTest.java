package de.claudioaltamura.java.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Condition;
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
  public void testDoesNotThrowAnyException() {
    Car car = new Car();
    assertThatCode(
        () -> {
          car.hoot();
        })
    .doesNotThrowAnyException();
  }

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

    assertThat(cars).filteredOn(car -> car.getName().contains("W")).extracting(Car::getName)
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

    Condition<Car> bmwCondition = new Condition<Car>() {
      @Override
      public boolean matches(Car car) {
        return "BMW".equals(car.getName());
      }
    };
    assertThat(cars).filteredOn(bmwCondition).containsOnly(bmw);

  }

  @Test
  void testFilterOnProperty() {
    List<Car> cars = this.createCarList();

    assertThat(cars).filteredOn("name", "BMW").size().isEqualTo(1);
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

  private List<Car>	createCarList() {
	  List<Car> cars = new ArrayList<>();

	  Car bmw = new Car();
	  bmw.setName("BMW");
	  bmw.setColor("white");
	  cars.add(bmw);
	  Car mercedes = new Car();
	  mercedes.setName("Mercedes");
	  mercedes.setName("black");
	  cars.add(mercedes);
	  Car vw = new Car();
	  vw.setName("Ferrari");
	  vw.setName("red");
	  cars.add(vw);

	  return cars;
  }

}
