package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {
  Optional<Patient> findByEmail(String email);
}
