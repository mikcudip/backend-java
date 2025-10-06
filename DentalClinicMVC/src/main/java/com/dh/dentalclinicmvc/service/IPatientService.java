package com.dh.dentalclinicmvc.service;

import com.dh.dentalclinicmvc.model.Patient;

public interface IPatientService extends IBaseService<Patient, Long> {
  Patient findByEmail(String email);
}
