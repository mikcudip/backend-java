package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.entity.Patient;

public interface IPatientService extends IBaseService<Patient, Long> {
  Patient findByEmail(String email);
}
