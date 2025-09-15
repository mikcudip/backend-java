package com.clinicaodontologicaspring.dao.impl;

import com.clinicaodontologicaspring.dao.IDAO;
import com.clinicaodontologicaspring.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDAOH2 implements IDAO<Patient> {
  @Override
  public Patient save(Patient patient) {
    return null;
  }

  @Override
  public Boolean update(Patient patient) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }

  @Override
  public Patient findById(Long id) {
    return null;
  }

  @Override
  public List<Patient> findAll() {
    return List.of();
  }
}
