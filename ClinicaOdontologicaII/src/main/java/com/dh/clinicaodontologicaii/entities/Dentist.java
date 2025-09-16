package com.dh.clinicaodontologicaii.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dentists")
public class Dentist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dentist_id")
  private Integer id;
  @Column(name = "registration")
  private Integer registration;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  public Dentist() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRegistration() {
    return registration;
  }

  public void setRegistration(Integer registration) {
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
