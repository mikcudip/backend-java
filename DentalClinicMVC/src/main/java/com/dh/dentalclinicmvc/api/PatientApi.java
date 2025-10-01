package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Patient;
import com.dh.dentalclinicmvc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientApi implements BaseApi<Patient, Long> {
  PatientService patientService;

  @Autowired
  public PatientApi(PatientService patientService) {
    this.patientService = patientService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Patient> save(@RequestBody Patient patient) {
    return ResponseEntity.ok(patientService.save(patient));
  }

  @Override
  @PutMapping
  public void update(@RequestBody Patient patient) {
    patientService.update(patient);
  }

  @Override
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    patientService.delete(id);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Patient> findById(@PathVariable Long id) {
    return ResponseEntity.ok(patientService.findById(id));
  }

  @Override
  @GetMapping
  public ResponseEntity<List<Patient>> findAll() {
    return ResponseEntity.ok(patientService.findAll());
  }
}
