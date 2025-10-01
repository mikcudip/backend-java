package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Appointment;
import com.dh.dentalclinicmvc.service.AppointmentService;
import com.dh.dentalclinicmvc.service.DentistService;
import com.dh.dentalclinicmvc.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentApi implements BaseApi<Appointment, Long> {
  private final PatientService patientService;
  private final DentistService dentistService;
  private final AppointmentService appointmentService;

  public AppointmentApi(AppointmentService appointmentService, PatientService patientService, DentistService dentistService) {
    this.appointmentService = appointmentService;
    this.patientService = patientService;
    this.dentistService = dentistService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
    if (patientService.findById(appointment.getPatient().getId()) != null && dentistService.findById(appointment.getDentist().getId()) != null) {
      return ResponseEntity.ok(appointmentService.save(appointment));
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @Override
  public ResponseEntity<Appointment> findById(Long id) {
    return ResponseEntity.ok(appointmentService.findById(id));
  }

  @Override
  public void update(Appointment appointment) {
    appointmentService.save(appointment);
  }

  @Override
  public void delete(Long id) {
    appointmentService.delete(id);
  }

  @Override
  public ResponseEntity<List<Appointment>> findAll() {
    return ResponseEntity.ok(appointmentService.findAll());
  }
}
