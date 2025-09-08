package core.service;

import core.dao.IDAO;
import core.model.Dentist;

import java.util.List;

public class DentistService {
  private IDAO<Dentist> dentistIDAO;

  public DentistService(IDAO<Dentist> dentistIDAO) {
    this.dentistIDAO = dentistIDAO;
  }

  public Dentist save(Dentist dentist) {
    return dentistIDAO.save(dentist);
  }

  public Boolean update(Dentist dentist) {
    return dentistIDAO.update(dentist);
  }

  public Boolean delete(Long id) {
    return dentistIDAO.delete(id);
  }

  public Dentist findById(Long id) {
    return dentistIDAO.findById(id);
  }

  public List<Dentist> findAll() {
    return dentistIDAO.findAll();
  }
}
