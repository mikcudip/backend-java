package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.dao.DentistDAOH2;
import com.dh.dentalclinicmvc.dao.IDAO;
import com.dh.dentalclinicmvc.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService implements BaseService<Dentist, Long> {
  private final IDAO<Dentist> dentistIDAO;

  public DentistService() {
    dentistIDAO = new DentistDAOH2();
  }

  public Dentist save(Dentist dentist) {
    return dentistIDAO.save(dentist);
  }

  public Dentist findById(Long id) {
    return dentistIDAO.findById(id);
  }

  public void update(Dentist dentist) {
    dentistIDAO.update(dentist);
  }

  public void delete(Long id) {
    dentistIDAO.delete(id);
  }

  public List<Dentist> findAll() {
    return dentistIDAO.findAll();
  }
}
