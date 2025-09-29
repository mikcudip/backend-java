package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.dao.IDAO;
import com.dh.dentalclinicmvc.dao.PatientDAOH2;
import com.dh.dentalclinicmvc.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
  private IDAO<Patient> patientDAO;

  public PatientService() {
    this.patientDAO = new PatientDAOH2();
  }

  public Patient save(Patient patient) {
    return patientDAO.save(patient);
  }

  public void update(Patient patient) {
    patientDAO.update(patient);
  }

  public void delete(Long id) {
    patientDAO.delete(id);
  }

  public Patient findById(Long id) {
    return patientDAO.findById(id);
  }

  public List<Patient> findAll() {
    return patientDAO.findAll();
  }

  public Patient findByEmail(String email) {
    return patientDAO.findByString(email);
  }
}
