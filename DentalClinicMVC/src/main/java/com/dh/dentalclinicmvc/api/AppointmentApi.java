package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Appointment;
import com.dh.dentalclinicmvc.service.IAppointmentService;
import com.dh.dentalclinicmvc.service.IDentistService;
import com.dh.dentalclinicmvc.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentApi implements BaseApi<Appointment, Long> {
  private final IAppointmentService appointmentService;
  private final IPatientService patientService;
  private final IDentistService dentistService;

  @Autowired
  public AppointmentApi(IAppointmentService appointmentService, IPatientService patientService, IDentistService dentistService) {
    this.appointmentService = appointmentService;
    this.patientService = patientService;
    this.dentistService = dentistService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
    if (!patientService.existsById(appointment.getPatient().getId())) {
      return ResponseEntity.badRequest().build();
    }
    if (!dentistService.existsById(appointment.getDentist().getId())) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(appointmentService.save(appointment));
  }

  @Override
  @PutMapping
  public ResponseEntity<String> update(@RequestBody Appointment appointment) {
    if (!patientService.existsById(appointment.getPatient().getId())) {
      return ResponseEntity.ok("No se puede actualizar un turno que no existe en la base de datos.");
    }
    if (!dentistService.existsById(appointment.getDentist().getId())) {
      return ResponseEntity.ok("No se puede actualizar un turno que no existe en la base de datos.");
    }
    if (!appointmentService.update(appointment)) {
      return ResponseEntity.ok("No se puede actualizar un turno que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se actualizó el turno.");
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (!appointmentService.deleteById(id)) {
      return ResponseEntity.ok("No se puede eliminar un turno que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se eliminó el turno.");
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Appointment> findById(@PathVariable Long id) {
    Appointment appointment = appointmentService.findById(id);
    if (appointment == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(appointment);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<Appointment>> findAll() {
    return ResponseEntity.ok(appointmentService.findAll());
  }
}
