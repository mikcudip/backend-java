package com.dh.dentalclinicmvc.model;

import java.time.LocalDate;

public class Appointment {
  private Long id;
  private Patient patient;
  private Dentist dentist;
  private LocalDate date;

  public Appointment(Long id, Patient patient, Dentist dentist, LocalDate date) {
    this.id = id;
    this.patient = patient;
    this.dentist = dentist;
    this.date = date;
  }

  public Appointment(Patient patient, Dentist dentist, LocalDate date) {
    this.patient = patient;
    this.dentist = dentist;
    this.date = date;
  }

  public Appointment() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Dentist getDentist() {
    return dentist;
  }

  public void setDentist(Dentist dentist) {
    this.dentist = dentist;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
