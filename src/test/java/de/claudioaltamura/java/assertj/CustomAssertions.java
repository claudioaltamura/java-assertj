package de.claudioaltamura.java.assertj;

public class CustomAssertions {
  public static CarAssert assertThat(Car actual) {
    return new CarAssert(actual);
  }
}
