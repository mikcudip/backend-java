package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.dao.IDAO;
import com.dh.dentalclinicmvc.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements BaseService<Patient, Long> {
  private IDAO<Patient> patientIDAO;

  public PatientService(IDAO<Patient> patientIDAO) {
    this.patientIDAO = patientIDAO;
  }

  public Patient save(Patient patient) {
    return patientIDAO.save(patient);
  }

  public void update(Patient patient) {
    patientIDAO.update(patient);
  }

  public void delete(Long id) {
    patientIDAO.delete(id);
  }

  public Patient findById(Long id) {
    return patientIDAO.findById(id);
  }

  public List<Patient> findAll() {
    return patientIDAO.findAll();
  }

  public Patient findByEmail(String email) {
    return patientIDAO.findByString(email);
  }
}
