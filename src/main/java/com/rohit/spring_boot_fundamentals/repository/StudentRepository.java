package com.rohit.spring_boot_fundamentals.repository;

import com.rohit.spring_boot_fundamentals.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    List<Student> findByNameContaining(String name);

    List<Student> findByNameStartingWith(String name);

    List<Student> findByNameContainingIgnoreCase(String name);
}
