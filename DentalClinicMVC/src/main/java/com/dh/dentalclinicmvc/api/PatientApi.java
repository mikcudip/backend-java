package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Patient;
import com.dh.dentalclinicmvc.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientApi implements BaseApi<Patient, Long> {
  private final IPatientService patientService;

  @Autowired
  public PatientApi(IPatientService patientService) {
    this.patientService = patientService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Patient> save(@RequestBody Patient patient) {
    return ResponseEntity.ok(patientService.save(patient));
  }

  @Override
  @PutMapping
  public ResponseEntity<String> update(@RequestBody Patient patient) {
    if (!patientService.update(patient)) {
      return ResponseEntity.ok("No se puede actualizar un paciente que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se actualizó el paciente.");
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (!patientService.deleteById(id)) {
      return ResponseEntity.ok("No se puede eliminar un paciente que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se eliminó el paciente.");
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Patient> findById(@PathVariable Long id) {
    Patient patient = patientService.findById(id);
    if (patient == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(patient);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<Patient>> findAll() {
    return ResponseEntity.ok(patientService.findAll());
  }
}
