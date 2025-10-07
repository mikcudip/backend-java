package com.dh.dentalclinicmvc.dto;

public class AppointmentDTO extends DTO {
  private Long id;
  private Long dentistId;
  private Long patientId;
  private String date;

  public AppointmentDTO() {
  }

  public AppointmentDTO(Long id, Long dentistId, Long patientId, String date) {
    this.id = id;
    this.dentistId = dentistId;
    this.patientId = patientId;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDentistId() {
    return dentistId;
  }

  public void setDentistId(Long dentistId) {
    this.dentistId = dentistId;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
