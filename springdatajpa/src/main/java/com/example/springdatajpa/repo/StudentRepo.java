package com.example.springdatajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name = ?1")
    List<Student> findByName(String name);

    List<Student> findByMarks(int marks); // jpa creates methods behind the scene using Query DSL and works without using @Query (not always)

    List<Student> findByMarksGreaterThan(int marks);

    
}
