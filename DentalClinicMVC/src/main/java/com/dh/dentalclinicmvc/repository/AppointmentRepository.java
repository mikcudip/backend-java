package com.dh.dentalclinicmvc.repository;

import com.dh.dentalclinicmvc.entity.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long> {
}
