package com.dh.dentalclinicmvc.service.impl;

import com.dh.dentalclinicmvc.entity.Patient;
import com.dh.dentalclinicmvc.repository.PatientRepository;
import com.dh.dentalclinicmvc.service.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
  private final PatientRepository patientRepository;

  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Override
  public Patient save(Patient patient) {
    if (patient.getId() != null) {
      if (patientRepository.existsById(patient.getId())) {
        return null;
      }
    }
    return patientRepository.save(patient);
  }

  @Override
  public boolean update(Patient patient) {
    if (patient.getId() == null) {
      return false;
    }
    if (!patientRepository.existsById(patient.getId())) {
      return false;
    }
    patientRepository.save(patient);
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
    if (id == null) {
      return false;
    }
    if (!patientRepository.existsById(id)) {
      return false;
    }
    patientRepository.deleteById(id);
    return true;
  }

  @Override
  public boolean existsById(Long id) {
    return patientRepository.existsById(id);
  }

  @Override
  public Patient findById(Long id) {
    return patientRepository.findById(id).orElse(null);
  }

  @Override
  public Patient findByEmail(String email) {
    return patientRepository.findByEmail(email).orElse(null);
  }

  @Override
  public List<Patient> findAll() {
    return patientRepository.findAll();
  }
}
