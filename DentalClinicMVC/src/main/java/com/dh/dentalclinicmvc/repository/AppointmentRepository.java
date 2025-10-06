package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.model.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {
}
