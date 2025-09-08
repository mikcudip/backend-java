package core;

import java.util.ArrayList;
import java.util.List;

public class Group {
  private List<Person> people;

  public Group() {
    people = new ArrayList<>();
  }

  public void addPerson(Person person) {
    Boolean isOlder = person.isOlder();
    Boolean name5Check = person.name5Check();
    Boolean nameAZCheck = person.nameAZCheck();
    Boolean ageCheck = person.ageCheck();
    if (isOlder && name5Check && nameAZCheck && ageCheck) people.add(person);
    return;
  }

  public List<Person> getPeople() {
    return people;
  }

  public void setPeople(List<Person> people) {
    this.people = people;
  }
}
