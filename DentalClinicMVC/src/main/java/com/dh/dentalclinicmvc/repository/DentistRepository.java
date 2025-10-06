package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.model.Dentist;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends BaseRepository<Dentist, Long> {
}
