package com.clinicaodontologicaspring.model;

import java.time.LocalDate;

public class Patient {
  private Long id;
  private String firstName;
  private String lastName;
  private String cardIdentity;
  private LocalDate admissionDate;

  public Patient(String firstName, String lastName, String cardIdentity, LocalDate admissionDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cardIdentity = cardIdentity;
    this.admissionDate = admissionDate;
  }

  public Patient(Long id, String firstName, String lastName, String cardIdentity, LocalDate admissionDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cardIdentity = cardIdentity;
    this.admissionDate = admissionDate;
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

  public String getCardIdentity() {
    return cardIdentity;
  }

  public void setCardIdentity(String cardIdentity) {
    this.cardIdentity = cardIdentity;
  }

  public LocalDate getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(LocalDate admissionDate) {
    this.admissionDate = admissionDate;
  }
}
