package com.dh.dentalclinicmvc.dao;

import com.dh.dentalclinicmvc.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentDAOList implements IDAO<Appointment> {
  private List<Appointment> appointments;

  public AppointmentDAOList() {
    appointments = new ArrayList<>();
  }

  @Override
  public Appointment save(Appointment appointment) {
    appointments.add(appointment);
    return appointment;
  }

  @Override
  public Appointment findById(Long id) {
    for (Appointment appointment : appointments) {
      if (appointment.getId().equals(id)) {
        return appointment;
      }
    }
    return null;
  }

  @Override
  public void update(Appointment entity) {

  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Appointment> findAll() {
    return List.of();
  }

  @Override
  public Appointment findByString(String value) {
    return null;
  }
}
