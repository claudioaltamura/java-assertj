package de.claudioaltamura.java.assertj;

import org.assertj.core.api.AbstractAssert;

public class CarAssert extends AbstractAssert<CarAssert, Car> {

    public CarAssert(Car actual) {
        super(actual, CarAssert.class);
    }

    public static CarAssert assertThat(Car actual) {
        return new CarAssert(actual);
    }

    public CarAssert hasName() {
        isNotNull();
        if(actual.getName().isBlank()) {
            failWithMessage("Expected car to a name.");
        }
        return this;
    }
    public CarAssert hasFourWheels() {
        isNotNull();
        if (actual.getWheels() < 4) {
            failWithMessage("Expected car to have 4 wheels.");
        }
        return this;
    }

}
