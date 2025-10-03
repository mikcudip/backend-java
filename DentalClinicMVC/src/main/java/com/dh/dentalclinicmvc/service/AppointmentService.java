package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.dao.IDAO;
import com.dh.dentalclinicmvc.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements BaseService<Appointment, Long> {
  private IDAO<Appointment> appointmentIDAO;

  public AppointmentService(IDAO<Appointment> appointmentIDAO) {
    this.appointmentIDAO = appointmentIDAO;
  }

  @Override
  public Appointment save(Appointment appointment) {
    return appointmentIDAO.save(appointment);
  }

  @Override
  public Appointment findById(Long id) {
    return appointmentIDAO.findById(id);
  }

  @Override
  public void update(Appointment appointment) {
    appointmentIDAO.update(appointment);
  }

  @Override
  public void delete(Long id) {
    appointmentIDAO.delete(id);
  }

  @Override
  public List<Appointment> findAll() {
    return appointmentIDAO.findAll();
  }
}
