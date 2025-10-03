package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
  PatientService patientService;

  @Autowired
  public PatientServiceTest(PatientService patientService) {
    this.patientService = patientService;
  }

  @Test
  void findById() {
    Long idPatient = 1L;
    // Search patient
    Patient patient = patientService.findById(idPatient);
    assertNotNull(patient);
  }
}
