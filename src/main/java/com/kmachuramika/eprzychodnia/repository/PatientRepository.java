package com.kmachuramika.eprzychodnia.repository;

import com.kmachuramika.eprzychodnia.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository  extends JpaRepository<Patient, UUID> {

    List<Patient> findAll();
}
