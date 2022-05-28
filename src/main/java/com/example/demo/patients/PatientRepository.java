package com.example.demo.patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
     // SELECT * FROM student WHERE email = ?
     // OR
    @Query("SELECT p FROM Patient p WHERE p.email = ?1")
    Optional<Patient> findByEmail(String email);
}
