package com.dh.dentalclinicmvc.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dentists")
public class Dentist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "registration")
  private Long registration;

  @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
  private List<Appointment> appointment;

  public Dentist() {
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

  public List<Appointment> getAppointment() {
    return appointment;
  }

  public void setAppointment(List<Appointment> appointment) {
    this.appointment = appointment;
  }
}
