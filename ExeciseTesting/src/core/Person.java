package core;

public class Person {
  private String name;
  private Integer age;

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge() {
    this.age = age;
  }

  public Boolean isOlder() {
    return age > 18;
  }

  public Boolean ageCheck() {
    return (age >= 0 && age <= 120);
  }

  public Boolean name5Check() {
    return name.length() >= 5;
  }

  public Boolean nameAZCheck() {
    for (Character letter : name.toCharArray()) {
      if (Character.isLetter(letter)) return false;
    }
    return true;
  }
}
