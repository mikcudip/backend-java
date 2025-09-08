package dao.impl;

import dao.IDAO;
import model.Patient;

import java.util.List;

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
