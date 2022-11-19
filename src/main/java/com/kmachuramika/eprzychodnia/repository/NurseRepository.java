package com.kmachuramika.eprzychodnia.repository;

import com.kmachuramika.eprzychodnia.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NurseRepository extends JpaRepository<Nurse, UUID> {
}
