package com.dh.dentalclinicmvc.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "date")
  private LocalDate date;

  @ManyToOne(fetch = FetchType.EAGER)
  private Patient patient;
  @ManyToOne(fetch = FetchType.EAGER)
  private Dentist dentist;

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
