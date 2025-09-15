package com.clinicaodontologicaspring.service;

import com.clinicaodontologicaspring.model.Patient;
import com.clinicaodontologicaspring.dao.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
  private IDAO<Patient> patientIDAO;

  @Autowired
  public PatientService(IDAO<Patient> PatientIDAO) {
    this.patientIDAO = PatientIDAO;
  }

  public Patient save(Patient Patient) {
    return patientIDAO.save(Patient);
  }

  public Boolean update(Patient Patient) {
    return patientIDAO.update(Patient);
  }

  public Boolean delete(Long id) {
    return patientIDAO.delete(id);
  }

  public Patient findById(Long id) {
    return patientIDAO.findById(id);
  }

  public List<Patient> findAll() {
    return patientIDAO.findAll();
  }
}
