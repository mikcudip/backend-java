package com.dh.clinicaodontologicaii.service;

import com.dh.clinicaodontologicaii.entities.Dentist;
import com.dh.clinicaodontologicaii.repository.DentistRepository;
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

  public Dentist save(Dentist dentist) {
    return patientRepository.save(dentist);
  }

  public Dentist findById(Integer id) {
    return patientRepository.findById(id).orElse(null);
  }

  public void update(Dentist dentist) {
    patientRepository.save(dentist);
  }

  public void delete(Integer id) {
    patientRepository.deleteById(id);
  }

  public List<Dentist> findAll() {
    return patientRepository.findAll();
  }
}
