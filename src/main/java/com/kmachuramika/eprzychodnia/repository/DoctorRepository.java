package com.kmachuramika.eprzychodnia.repository;

import com.kmachuramika.eprzychodnia.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
