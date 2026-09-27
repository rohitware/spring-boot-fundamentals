package com.rohit.spring_boot_fundamentals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.spring_boot_fundamentals.model.Student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/students")
@RestController
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Rohit"),
                new Student(2, "Amit"),
                new Student(3, "Priya"));
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return new Student(id, "Rohit");
    }

}
