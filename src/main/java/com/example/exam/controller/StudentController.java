package com.example.exam.controller;

import com.example.exam.entity.Student;
import com.example.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<Student> get() {
    return studentService.get();
  }

  @GetMapping("/{id}")
  private Student getStudentByID(@PathVariable("id") Long id) {
    return studentService.getStudentByID(id);
  }

  @PostMapping
  public String saveStudent(@RequestBody Student students) {
    studentService.saveStudent(students);
    return "Student add success";
  }
//
//  @PutMapping
//  public String update(@RequestBody StudentDTO studentDTO) {
//    studentService.update((studentDTO));
//    return " Student update success";
//  }

    @PutMapping
  public String update(@RequestBody Student students) {
    studentService.update((students));
    return " Student update success";
    }
//cascade
  @DeleteMapping("/{id}")
  private void deleteStudents(@PathVariable("id") Long id) {
    studentService.delete(id);
  }

}
