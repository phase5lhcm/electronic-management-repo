package com.example.demo.patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// add queries to this file for interacting with db
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    static String findPatientByEmail() {
        return "Need to add functionality here";
    }

    // SELECT * FROM student WHERE email = ?
     // OR
    @Query("SELECT p FROM Patient p WHERE p.email = ?1")
    Optional<Patient> findByEmail(String email);
}
