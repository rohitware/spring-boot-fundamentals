package com.rohit.spring_boot_fundamentals.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rohit.spring_boot_fundamentals.model.Student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Rohit"),
                new Student(2, "Amit"),
                new Student(3, "Priya"));
    }

}
