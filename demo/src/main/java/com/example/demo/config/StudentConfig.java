package com.example.demo.config;

import com.example.demo.model.entity.StudentModel;
import com.example.demo.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository) {

        return args -> {
            StudentModel mariam = new StudentModel(
                    "mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentModel alex = new StudentModel(
                    "Alex",
                    "alex2gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentModel john = new StudentModel(
                    "john",
                    "john@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentModel tony = new StudentModel(
                    "tony",
                    "tony@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentModel jane = new StudentModel(
                    "jane",
                    "jane@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            StudentModel jack = new StudentModel(
                    "jack",
                    "jack@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            repository.saveAll(List.of(mariam, alex, john, tony, jane, jack));
        };
    }
}
