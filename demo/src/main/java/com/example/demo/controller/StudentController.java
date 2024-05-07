package com.example.demo.controller;

import com.example.demo.model.entity.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //met constractor ook mogelijk maar mort eenje kiezen

    @GetMapping
//public String hello(){
    //  return "hello";
//}
    public List<StudentModel> getStudents() {
        return studentService.getStudent();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody StudentModel student) {
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);

    }

}
