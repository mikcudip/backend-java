package com.dh.dentalclinicmvc.service.impl;

import com.dh.dentalclinicmvc.dto.AppointmentDTO;
import com.dh.dentalclinicmvc.entity.Appointment;
import com.dh.dentalclinicmvc.entity.Dentist;
import com.dh.dentalclinicmvc.entity.Patient;
import com.dh.dentalclinicmvc.repository.AppointmentRepository;
import com.dh.dentalclinicmvc.service.IAppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public Appointment save(Appointment appointment) {
    if (appointment.getId() != null) {
      if (appointmentRepository.existsById(appointment.getId())) {
        return null;
      }
    }
    return appointmentRepository.save(appointment);
  }

  @Override
  public AppointmentDTO saveDTO(AppointmentDTO appointmentDTO) {
    if (appointmentDTO.getId() != null) {
      if (appointmentRepository.existsById(appointmentDTO.getId())) {
        return null;
      }
    }
    Appointment appointment = appointmentRepository.save(IAppointmentService.appointmentDTOToEntity(appointmentDTO));
    appointmentDTO.setId(appointment.getId());
    return appointmentDTO;
  }

  @Override
  public boolean update(Appointment appointment) {
    if (appointment.getId() == null) {
      return false;
    }
    if (!appointmentRepository.existsById(appointment.getId())) {
      return false;
    }
    appointmentRepository.save(appointment);
    return true;
  }

  @Override
  public AppointmentDTO updateDTO(AppointmentDTO appointmentDTO) {
    if (appointmentDTO.getId() == null) {
      return null;
    }
    if (!appointmentRepository.existsById(appointmentDTO.getId())) {
      return null;
    }
    Appointment appointment = appointmentRepository.save(IAppointmentService.appointmentDTOToEntity(appointmentDTO));
    appointmentDTO.setId(appointment.getId());
    return appointmentDTO;
  }

  @Override
  public boolean deleteById(Long id) {
    if (id == null) {
      return false;
    }
    if (!appointmentRepository.existsById(id)) {
      return false;
    }
    appointmentRepository.deleteById(id);
    return true;
  }

  @Override
  public boolean existsById(Long id) {
    return appointmentRepository.existsById(id);
  }

  @Override
  public Appointment findById(Long id) {
    return appointmentRepository.findById(id).orElse(null);
  }

  @Override
  public AppointmentDTO findByIdDTO(Long id) {
    return IAppointmentService.appointmentToappointmentDTO(appointmentRepository.findById(id).orElse(null));
  }

  @Override
  public List<Appointment> findAll() {
    return appointmentRepository.findAll();
  }

  @Override
  public List<AppointmentDTO> findAllDTO() {
    List<Appointment> appointments = appointmentRepository.findAll();
    List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
    for (Appointment appointment : appointments) {
      appointmentDTOS.add(IAppointmentService.appointmentToappointmentDTO(appointment));
    }
    return appointmentDTOS;
  }
}
