package com.dh.clinicaodontologicaii.repository;

import com.dh.clinicaodontologicaii.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
  @Query("FROM Patient p WHERE p.lastName = ?1")
  Optional<Patient> findByLastName(String lastName);

  @Query("FROM Patient p WHERE p.firstName = ?1")
  Optional<Patient> findByFirstName(String firstName);
}
