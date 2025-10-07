package com.dh.dentalclinicmvc.service.impl;

import com.dh.dentalclinicmvc.entity.Dentist;
import com.dh.dentalclinicmvc.repository.DentistRepository;
import com.dh.dentalclinicmvc.service.IDentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService implements IDentistService {
  private final DentistRepository dentistRepository;

  public DentistService(DentistRepository dentistRepository) {
    this.dentistRepository = dentistRepository;
  }

  @Override
  public Dentist save(Dentist dentist) {
    if (dentist.getId() != null) {
      if (dentistRepository.existsById(dentist.getId())) {
        return null;
      }
    }
    return dentistRepository.save(dentist);
  }

  @Override
  public boolean update(Dentist dentist) {
    if (dentist.getId() == null) {
      return false;
    }
    if (!dentistRepository.existsById(dentist.getId())) {
      return false;
    }
    dentistRepository.save(dentist);
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
    if (id == null) {
      return false;
    }
    if (!dentistRepository.existsById(id)) {
      return false;
    }
    dentistRepository.deleteById(id);
    return true;
  }


  @Override
  public boolean existsById(Long id) {
    return dentistRepository.existsById(id);
  }

  @Override
  public Dentist findById(Long id) {
    return dentistRepository.findById(id).orElse(null);
  }

  @Override
  public List<Dentist> findAll() {
    return dentistRepository.findAll();
  }
}
