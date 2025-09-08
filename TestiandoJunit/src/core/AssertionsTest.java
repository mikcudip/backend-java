package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class AssertionsTest {
  @Test
  void equalsAssertion() {
    int number = 2;
    int otherNumber = 2;
    Assertions.assertEquals(number, otherNumber);
  }

  @Test
  void notEqualsAssertion() {
    int number = 2;
    int otherNumber = 3;
    Assertions.assertNotEquals(number, otherNumber);
  }

  @Test
  void arraysEqualsAssertion() {
    char[] expected = {'J', 'a', 'v', 'a'};
    char[] actual = "Java".toCharArray();
    Assertions.assertArrayEquals(expected, actual, "Arrays are not equal");
  }

  @Test
  void trueAssertion() {
    Assertions.assertTrue(7 > 1, "7 is greater than 1");
  }

  @Test
  void trueAssertion1() {
    BooleanSupplier condition = () -> 7 > 1;
    Assertions.assertTrue(condition, "7 is greater than 1");
  }

  @Test
  void falseAssertion() {
    Assertions.assertFalse(7 > 10, "7 is not greater than 10");
  }

  @Test
  void notNullAssertion() {
    Object course = new Object();
    Assertions.assertNotNull(course, "The course should not be null");
  }

  @Test
  void nullAssertion() {
    Object course = null;
    Assertions.assertNull(course, "The course should not be null");
  }

  @Test
  void sameAssertion() {
    String course = "Java";
    Optional<String> optionalCourse = Optional.of(course);
    Assertions.assertSame("Java", optionalCourse.get(), "The course should be same");
  }

  @Test
  void notSameAssertion() {
    String course = "Java";
    String otherCourse = "JavaScript";
    Optional<String> optionalCourse = Optional.of(course);
    Assertions.assertNotSame(otherCourse, optionalCourse.get(), "The course should be same");
  }

  @Test
  void allAssertions() {
    Assertions.assertAll(
        () -> Assertions.assertEquals(4, 2 * 2),
        () -> Assertions.assertEquals("backend", "BACKEND".toLowerCase()),
        () -> Assertions.assertNotEquals(2, 3),
        () -> Assertions.assertNull(null, "actual should be null")
    );
  }

  @Test
  void iterableEqualsAssertion() {
    Iterable<String> arrayList = new ArrayList<>(Arrays.asList("Java", "Junit", "Test2"));
    Iterable<String> linkedList = new LinkedList<>(Arrays.asList("Java", "Junit", "Test2"));
    Assertions.assertIterableEquals(arrayList, linkedList);
  }

  @Test
  void linesMatchAssertion() {
    Iterable<String> expected = Arrays.asList("Java", "Junit", "Test2");
    Iterable<String> actual = Arrays.asList("Java", "Junit", "Test2");
    Assertions.assertIterableEquals(expected, actual);
  }

  @Test
  void throwsAssertion() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Integer.parseInt("Java");
    });
  }

  @Test
  void timeOutAssertion() {
    Assertions.assertTimeout(
        Duration.ofSeconds(2),
        () -> {
          Thread.sleep(1000);
        }
    );
  }

  @Test
  void timeOutPreemptivelyAssertion() {
    Assertions.assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          Thread.sleep(1999);
        }
    );
  }
}
