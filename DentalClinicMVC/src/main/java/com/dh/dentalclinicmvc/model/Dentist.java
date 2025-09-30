package com.dh.dentalclinicmvc.model;

public class Dentist {
  private Long id;
  private String firstName;
  private String lastName;
  private Long registration;

  public Dentist(Long id, String firstName, String lastName, Long registration) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.registration = registration;
  }

  public Dentist(String firstName, String lastName, Long registration) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.registration = registration;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Long getRegistration() {
    return registration;
  }

  public void setRegistration(Long registration) {
    this.registration = registration;
  }
}
