package com.example.demo.patients;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PatientService {
    public List<Patient> getPatients() {
        return List.of(
                new Patient(
                        1L,
                        "Sandra",
                        "4444444444",
                        "sandra@mail.com",
                        23,
                        LocalDate.of(1995, Month.JANUARY, 1)
                )
        );

    }
}
