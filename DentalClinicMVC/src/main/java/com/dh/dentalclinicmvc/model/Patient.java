package com.dh.dentalclinicmvc.model;

import java.time.LocalDate;

public class Patient {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer cardIdentity;
  private LocalDate admissionDate;
  private Address address;

  public Patient() {
  }

  public Patient(String firstName, String lastName, String email, Integer cardIdentity, LocalDate admissionDate, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.cardIdentity = cardIdentity;
    this.admissionDate = admissionDate;
    this.address = address;
  }

  public Patient(Long id, String firstName, String lastName, String email, Integer cardIdentity, LocalDate admissionDate, Address address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.cardIdentity = cardIdentity;
    this.admissionDate = admissionDate;
    this.address = address;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getCardIdentity() {
    return cardIdentity;
  }

  public void setCardIdentity(Integer cardIdentity) {
    this.cardIdentity = cardIdentity;
  }

  public LocalDate getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(LocalDate admissionDate) {
    this.admissionDate = admissionDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
