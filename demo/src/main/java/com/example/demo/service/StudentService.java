package com.example.demo.service;

import com.example.demo.model.entity.StudentModel;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;
    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<StudentModel> getStudent() {
        return studentRepository.findAll();
        //return List.of(new StudentModel(1L, "Maryam", "maryam@gmail.com",
        // LocalDate.of(2000, Month.JANUARY, 5));
    }
    public void addNewStudent(StudentModel student) {
        Optional<StudentModel> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student id" + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
