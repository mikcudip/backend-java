package com.dh.clinicaodontologicaii.service;

import com.dh.clinicaodontologicaii.entities.Dentist;
import com.dh.clinicaodontologicaii.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {
  private DentistRepository dentistRepository;

  @Autowired
  public DentistService(DentistRepository dentistRepository) {
    this.dentistRepository = dentistRepository;
  }

  public Dentist save(Dentist dentist) {
    return dentistRepository.save(dentist);
  }

  public Dentist findById(Long id) {
    return dentistRepository.findById(id).orElse(null);
  }

  public boolean existsById(Long id) {
    return dentistRepository.existsById(id);
  }

  public void update(Dentist dentist) {
    dentistRepository.save(dentist);
  }

  public void delete(Long id) {
    dentistRepository.deleteById(id);
  }

  public List<Dentist> findAll() {
    return dentistRepository.findAll();
  }
}
