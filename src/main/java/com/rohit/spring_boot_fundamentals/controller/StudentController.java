package com.rohit.spring_boot_fundamentals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.spring_boot_fundamentals.dto.StudentRequestDto;
import com.rohit.spring_boot_fundamentals.dto.StudentResponseDto;
import com.rohit.spring_boot_fundamentals.dto.StudentUpdateRequestDto;
import com.rohit.spring_boot_fundamentals.model.Student;
import com.rohit.spring_boot_fundamentals.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import jakarta.validation.Valid;

@RequestMapping("/students")
@RestController
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return studentService.getAllStudentResponses();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable int id) {

        return studentService.getStudentResponseById(id);
    }

    @GetMapping("/search")
    public List<StudentResponseDto> getStudentsByName(
            @RequestParam String name) {
        return studentService.getStudentResponsesByName(name);
    }

    @GetMapping("/search/contains")
    public List<StudentResponseDto> searchStudentsByName(
            @RequestParam String name) {
        return studentService.searchStudentsResponceByName(name);
    }

    @GetMapping("/search/starts-with")
    public List<StudentResponseDto> searchStudentsByNameStartingWith(
            @RequestParam String name) {
        return studentService.searchStudentsResponceByNameStartingWith(name);
    }

    @GetMapping("/search/ignore-case")
    public List<StudentResponseDto> searchStudentsByNameIgnoreCase(
            @RequestParam String name) {
        return studentService.searchStudentResponsesByNameIgnoreCase(name);
    }

    @GetMapping("/search/by-id-name")
    public Student getStudentByIdAndName(
            @RequestParam Integer id,
            @RequestParam String name) {

        return studentService.getStudentByIdAndName(id, name);
    }

    @PostMapping
    public StudentResponseDto createStudent(
            @Valid @RequestBody StudentRequestDto requestDto) {
        return studentService.createStudent(requestDto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable int id,
            @Valid @RequestBody StudentUpdateRequestDto requestDto) {

        return studentService.updateStudent(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
