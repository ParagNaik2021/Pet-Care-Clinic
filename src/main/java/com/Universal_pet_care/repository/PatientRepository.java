package com.Universal_pet_care.repository;

import com.Universal_pet_care.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
