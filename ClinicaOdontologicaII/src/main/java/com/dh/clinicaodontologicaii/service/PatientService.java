package com.dh.clinicaodontologicaii.service;

import com.dh.clinicaodontologicaii.entities.Patient;
import com.dh.clinicaodontologicaii.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
  private PatientRepository patientRepository;

  @Autowired
  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public Patient save(Patient patient) {
    return patientRepository.save(patient);
  }

  public Patient findById(Long id) {
    return patientRepository.findById(id).orElse(null);
  }

  public boolean existsById(Long id) {
    return patientRepository.existsById(id);
  }

  public void update(Patient patient) {
    patientRepository.save(patient);
  }

  public void delete(Long id) {
    patientRepository.deleteById(id);
  }

  public List<Patient> findAll() {
    return patientRepository.findAll();
  }

  public Patient findByFirstName(String firstName) {
    return patientRepository.findByFirstName(firstName).orElse(null);
  }

  public Patient findByLastName(String lastName) {
    return patientRepository.findByLastName(lastName).orElse(null);
  }
}
