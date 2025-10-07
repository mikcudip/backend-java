package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.dto.AppointmentDTO;
import com.dh.dentalclinicmvc.service.IAppointmentService;
import com.dh.dentalclinicmvc.service.IDentistService;
import com.dh.dentalclinicmvc.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentApi {
  private final IAppointmentService appointmentService;
  private final IPatientService patientService;
  private final IDentistService dentistService;

  @Autowired
  public AppointmentApi(IAppointmentService appointmentService, IPatientService patientService, IDentistService dentistService) {
    this.appointmentService = appointmentService;
    this.patientService = patientService;
    this.dentistService = dentistService;
  }

  @PostMapping
  public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO appointmentDTO) {
    if (!patientService.existsById(appointmentDTO.getPatientId())) {
      return ResponseEntity.badRequest().build();
    }
    if (!dentistService.existsById(appointmentDTO.getDentistId())) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(appointmentService.saveDTO(appointmentDTO));
  }

  @PutMapping
  public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO) {
    if (!patientService.existsById(appointmentDTO.getPatientId())) {
      return ResponseEntity.badRequest().build();
    }
    if (!dentistService.existsById(appointmentDTO.getDentistId())) {
      return ResponseEntity.badRequest().build();
    }
    if (!appointmentService.existsById(appointmentDTO.getId())) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(appointmentService.updateDTO(appointmentDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (!appointmentService.deleteById(id)) {
      return ResponseEntity.ok("No se puede eliminar un turno que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se eliminó el turno.");
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) {
    AppointmentDTO appointmentDTO = appointmentService.findByIdDTO(id);
    if (appointmentDTO == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(appointmentDTO);
  }

  @GetMapping
  public ResponseEntity<List<AppointmentDTO>> findAll() {
    return ResponseEntity.ok(appointmentService.findAllDTO());
  }
}
