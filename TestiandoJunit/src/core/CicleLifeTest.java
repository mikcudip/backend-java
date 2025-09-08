package core;

import org.junit.jupiter.api.*;

public class CicleLifeTest {
  @BeforeAll
  static void initAll() {
  }

  @BeforeEach
  void init() {
  }

  @Test
  @Tag("myTest")
  void regularTestingMethod() {
  }

  @Test
  @Disabled
  void skippedTest() {
  }

  @AfterEach void tearDown() {
  }

  @AfterAll
  static void tearDownAll() {
  }

  @Test
  @Tag("myTest")
  void myTest() {
  }

  @Tag("otherTest")
  @Test
  void otherTest() {
  }
}
