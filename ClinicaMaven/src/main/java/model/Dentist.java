package model;

public class Dentist {
  private Long id;
  private Long registration;
  private String firstName;
  private String lastName;

  public Dentist() {
  }

  public Dentist(Long id, Long registration, String firstName, String lastName) {
    this.id = id;
    this.registration = registration;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Dentist(Long registration, String firstName, String lastName) {
    this.registration = registration;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRegistration() {
    return registration;
  }

  public void setRegistration(Long registration) {
    this.registration = registration;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
