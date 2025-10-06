package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<Patient, Long> {
}
