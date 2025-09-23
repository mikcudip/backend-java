package com.dh.clinicaodontologicaii.controller;

import com.dh.clinicaodontologicaii.entities.Patient;
import com.dh.clinicaodontologicaii.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
  private final PatientService patientService;

  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @PostMapping("/save")
  public Patient save(@RequestBody Patient patient) {
    return patientService.save(patient);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Patient> findById(@PathVariable Long id) {
    if (patientService.findById(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(patientService.findById(id));
  }


  @PutMapping("/{id}")
  public Patient update(@PathVariable Patient id) {
    if (!patientService.existsById(id.getId())) {
      return null;
    }
    patientService.update(id);
    return id;
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    if (!patientService.existsById(id)) {
      return "No se encontró el odontólogo con id: " + id;
    }
    patientService.delete(id);
    return "Se eliminó correctamente el odontólogo con id: " + id;
  }

  @GetMapping("/all")
  public List<Patient> findAll() {
    return patientService.findAll();
  }

  @GetMapping("/lastname/{lastName}")
  public Patient findByLastName(@PathVariable String lastName) {
    return patientService.findByLastName(lastName);
  }

  @GetMapping("/firstname/{firstName}")
  public Patient findByFirstName(@PathVariable String firstName) {
    return patientService.findByFirstName(firstName);
  }
}
