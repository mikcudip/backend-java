package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.entity.Dentist;

public interface IDentistService extends IBaseService<Dentist, Long> {
  Dentist findByRegistration(Long registration);
}
