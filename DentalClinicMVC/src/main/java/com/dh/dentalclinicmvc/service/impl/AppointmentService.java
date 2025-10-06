package com.dh.dentalclinicmvc.service.impl;

import com.dh.dentalclinicmvc.model.Appointment;
import com.dh.dentalclinicmvc.repository.AppointmentRepository;
import com.dh.dentalclinicmvc.service.IAppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public Appointment save(Appointment appointment) {
    if (appointmentRepository.existsById(appointment.getId())) {
      return null;
    }
    return appointmentRepository.save(appointment);
  }

  @Override
  public boolean update(Appointment appointment) {
    if (!appointmentRepository.existsById(appointment.getId())) {
      return false;
    }
    appointmentRepository.save(appointment);
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
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
  public List<Appointment> findAll() {
    return appointmentRepository.findAll();
  }
}
