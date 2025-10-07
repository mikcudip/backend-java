package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.entity.Dentist;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends BaseRepository<Dentist, Long> {
  //  @Query("SELECT d FROM Dentist d WHERE d.registration=?1")
  Optional<Dentist> findByRegistration(Long registration);
}
