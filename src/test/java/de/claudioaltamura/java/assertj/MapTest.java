package de.claudioaltamura.java.assertj;

import static de.claudioaltamura.java.assertj.TestDataProvider.createCarList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MapTest {

  @Test
  void size() {
    assertThat(createCarList()).isNotEmpty().hasSize(3);
  }
}
