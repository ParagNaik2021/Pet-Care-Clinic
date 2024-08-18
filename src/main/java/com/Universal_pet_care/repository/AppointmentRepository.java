package com.Universal_pet_care.repository;

import com.Universal_pet_care.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment findByAppointmentNo(String appointmentNo);
}
