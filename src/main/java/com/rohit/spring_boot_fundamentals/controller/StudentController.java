package com.rohit.spring_boot_fundamentals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.spring_boot_fundamentals.model.Student;
import com.rohit.spring_boot_fundamentals.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/students")
@RestController
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudent(id);
    }

    @GetMapping("/search")
    public List<Student> getStudentsByName(@RequestParam String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/search/contains")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }

    @GetMapping("/search/starts-with")
    public List<Student> searchStudentsByNameStartingWith(@RequestParam String name) {
        return studentService.searchStudentsByNameStartingWith(name);
    }

    @GetMapping("/search/ignore-case")
    public List<Student> getMsearchStudentsByNameIgnoreCaseethodName(@RequestParam String name) {
        return studentService.searchStudentsByNameIgnoreCase(name);
    }

    @GetMapping("/search/by-id-name")
    public Student getStudentByIdAndName(
            @RequestParam Integer id,
            @RequestParam String name) {

        return studentService.getStudentByIdAndName(id, name);
    }

    @PostMapping
    public Student creatStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
