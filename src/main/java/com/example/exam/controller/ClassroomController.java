package com.example.exam.controller;

import com.example.exam.entity.Classroom;
import com.example.exam.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
  @Autowired
  private ClassroomService classroomService;
//  private StudentService studentService;
  @GetMapping
  public List<Classroom> getClassroom() {
    return classroomService.getClassroom();
  }
//  @GetMapping("/student/{id}")
//  public List<Student> getAllStudentByClassroomId(int id) {
//    return StudentRepository.findAllByClassroom_Id(id);
//  }

  @GetMapping("/{id}")
  private Classroom getStudentByID(@PathVariable("id") Long id) {
    return classroomService.getClassroomByID(id);
  }

  @PostMapping
  public String saveClassroom(@RequestBody Classroom classrooms) {
    classroomService.saveClassroom((classrooms));
    return "Classroom add success";
  }

  @PutMapping
  public String updateClassroom(@RequestBody Classroom classrooms) {
    classroomService.updateClassroom((classrooms));
    return " Classroom update success";
  }

  @DeleteMapping("/{id}")
  private void deleteClassroom(@PathVariable("id") Long id) {
    classroomService.deleteClassroom(id);
  }
}
