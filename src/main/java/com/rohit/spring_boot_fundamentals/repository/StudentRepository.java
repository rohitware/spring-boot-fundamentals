package com.rohit.spring_boot_fundamentals.repository;

import com.rohit.spring_boot_fundamentals.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
