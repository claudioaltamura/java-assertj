package de.claudioaltamura.java.assertj;

import static de.claudioaltamura.java.assertj.TestDataProvider.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import org.junit.jupiter.api.Test;

class MapTest {

  @Test
  void testSize() {
    assertThat(createCarMap()).isNotEmpty().hasSize(3);
  }

  @Test
  void testEntry() {
    Car bmw = new Car();
    bmw.setName("BMW");
    bmw.setColor("white");

    assertThat(createCarMap()).contains(entry(bmw.getName(), bmw));
  }

  @Test
  void testContainsEntry() {
    Car bmw = new Car();
    bmw.setName("BMW");
    bmw.setColor("white");

    assertThat(createCarMap()).containsEntry(bmw.getName(), bmw);
  }

  @Test
  void testDoesNotContainsEntry() {
    Car abc = new Car();
    abc.setName("ABC");
    abc.setColor("white");

    assertThat(createCarMap()).doesNotContainEntry(abc.getName(), abc);
  }
}
