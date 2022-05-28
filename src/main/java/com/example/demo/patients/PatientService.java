package com.example.demo.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();

    }

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientByEmail = patientRepository
                .findByEmail(patient.getEmail());
        // TODO - add validation and better error handling
        if(patientByEmail.isPresent()){
            throw new IllegalStateException("Email already exists. Please login.");
        }
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        patientRepository.findById(patientId);
         boolean patientById = patientRepository.existsById(patientId);
         if (!patientById){
             throw new IllegalStateException(
                     "Patient" + patientId +"does not exist in system"
             );
         }
         patientRepository.deleteById(patientId);

    }

    @Transactional
    public void updatePatient(Long patientId, String name, String email) {
        Patient patientToUpdate = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException(
                        "Patient " + patientId +"does not exist in system"
                ));
        if (name != null &&
        name.length() > 0 &&
        !Objects.equals(patientToUpdate.getName(), name)){
            patientToUpdate.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(patientToUpdate.getEmail(), email)){
            // check if updated email already exists before allolwing patient to use it
            // TODO - actually add functionality to that method
            boolean patientOptional = Boolean.parseBoolean(PatientRepository.findPatientByEmail());
            if (patientOptional){
                throw new IllegalStateException("Email already exists, please try again");
            }
            patientToUpdate.setEmail(email);
        }
    }
}
