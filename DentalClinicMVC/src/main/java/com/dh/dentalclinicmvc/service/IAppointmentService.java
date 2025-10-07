package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.dto.AppointmentDTO;
import com.dh.dentalclinicmvc.entity.Appointment;
import com.dh.dentalclinicmvc.entity.Dentist;
import com.dh.dentalclinicmvc.entity.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface IAppointmentService extends IBaseService<Appointment, Long> {
  AppointmentDTO saveDTO(AppointmentDTO appointmentDTO);

  AppointmentDTO updateDTO(AppointmentDTO appointmentDTO);

  AppointmentDTO findByIdDTO(Long id);

  List<AppointmentDTO> findAllDTO();

  static AppointmentDTO appointmentToappointmentDTO(Appointment appointment) {
    if (appointment.getPatient() == null) return null;
    if (appointment.getDentist() == null) return null;
    if (appointment.getDate() == null) return null;

    return new AppointmentDTO(appointment.getId(), appointment.getPatient().getId(), appointment.getDentist().getId(), appointment.getDate().toString());
  }

  static Appointment appointmentDTOToEntity(AppointmentDTO appointmentDTO) {
    Appointment appointment = new Appointment();
    appointment.setId(appointmentDTO.getId());

    Patient patient = new Patient();
    patient.setId(appointmentDTO.getPatientId());
    Dentist dentist = new Dentist();
    dentist.setId(appointmentDTO.getDentistId());

    appointment.setPatient(patient);
    appointment.setDentist(dentist);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(appointmentDTO.getDate(), formatter);

    appointment.setDate(date);

    return appointment;
  }
}
