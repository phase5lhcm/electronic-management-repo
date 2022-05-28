package com.example.demo.patients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository){
        return args -> {
          Patient sandra =  new Patient(
                    "Sandra",
                    "4444444444",
                    "sandra@mail.com",
                    23,
                    LocalDate.of(1995, Month.JANUARY, 21)
            );

            Patient kara =  new Patient(
                    "Kara",
                    "4444444441",
                    "kara@mail.com",
                    23,
                    LocalDate.of(1993, Month.FEBRUARY, 21)
            );

            repository.saveAll(
                    List.of(sandra, kara)
            );
        };
    }
}
