package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {
  Optional<Patient> findByEmail(String email);
}
