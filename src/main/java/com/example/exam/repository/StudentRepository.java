package com.example.exam.repository;

import com.example.exam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  static List<Student> findAllByClassroom_Id(int id) {
    return findAllByClassroom_Id(id);
  }

}
