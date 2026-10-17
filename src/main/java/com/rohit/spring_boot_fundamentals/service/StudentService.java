package com.rohit.spring_boot_fundamentals.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rohit.spring_boot_fundamentals.dto.StudentRequestDto;
import com.rohit.spring_boot_fundamentals.dto.StudentResponseDto;
import com.rohit.spring_boot_fundamentals.model.Student;
import com.rohit.spring_boot_fundamentals.repository.StudentRepository;
import com.rohit.spring_boot_fundamentals.dto.StudentUpdateRequestDto;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentResponseDto> getAllStudentResponses() {

        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName()))
                .toList();
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<StudentResponseDto> getStudentResponsesByName(String name) {

        return studentRepository.findByName(name)
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName()))
                .toList();
    }

    public List<StudentResponseDto> searchStudentsResponceByName(String name) {
        return studentRepository.findByNameContaining(name)
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName()))
                .toList();
    }

    public List<StudentResponseDto> searchStudentsResponceByNameStartingWith(String name) {
        return studentRepository.findByNameStartingWith(name)
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName()))
                .toList();
    }

    public List<StudentResponseDto> searchStudentResponsesByNameIgnoreCase(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName()))
                .toList();
    }

    public StudentResponseDto getStudentResponseByIdAndName(Integer id, String name) {
        Student student = studentRepository.findByIdAndName(id, name)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found"));

        return new StudentResponseDto(student.getId(), student.getName());
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found"));

        existingStudent.setName(student.getName());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public StudentResponseDto getStudentResponseById(int id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found"));

        return new StudentResponseDto(
                student.getId(),
                student.getName());
    }

    public StudentResponseDto createStudent(StudentRequestDto requestDto) {

        Student student = new Student();
        student.setName(requestDto.getName());

        Student savedStudent = studentRepository.save(student);

        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName());
    }

    public StudentResponseDto updateStudent(
            int id,
            StudentUpdateRequestDto requestDto) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found"));

        existingStudent.setName(requestDto.getName());

        Student updatedStudent = studentRepository.save(existingStudent);

        return new StudentResponseDto(
                updatedStudent.getId(),
                updatedStudent.getName());
    }

}
