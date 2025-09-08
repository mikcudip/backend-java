package service;

import dao.IDAO;
import model.Patient;

import java.util.List;

public class PatientService {
  private IDAO<Patient> patientIDAO;

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
