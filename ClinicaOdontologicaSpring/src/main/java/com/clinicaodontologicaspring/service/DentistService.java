package com.clinicaodontologicaspring.service;

import com.clinicaodontologicaspring.dao.IDAO;
import com.clinicaodontologicaspring.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {
  private IDAO<Dentist> dentistIDAO;

  @Autowired
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
