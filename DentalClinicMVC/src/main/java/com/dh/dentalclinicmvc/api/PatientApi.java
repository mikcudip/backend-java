package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Patient;
import com.dh.dentalclinicmvc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientApi {
  PatientService patientService;

  @Autowired
  public PatientApi(PatientService patientService) {
    this.patientService = patientService;
  }

  @PostMapping("/save")
  public Patient save(@RequestBody Patient patient) {
    return patientService.save(patient);
  }

  @GetMapping("/all")
  public List<Patient> findAll() {
    return patientService.findAll();
  }
}
