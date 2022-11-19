package com.kmachuramika.eprzychodnia.service;

import com.kmachuramika.eprzychodnia.model.Patient;
import com.kmachuramika.eprzychodnia.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }



}
