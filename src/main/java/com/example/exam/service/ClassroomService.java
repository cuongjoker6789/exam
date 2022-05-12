package com.example.exam.service;

import com.example.exam.entity.Classroom;
import com.example.exam.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassroomService {
  @Autowired
  private ClassroomRepository classroomRepository;

  public List<Classroom> getClassroom() {
    return classroomRepository.findAll();
  }

  public Classroom getClassroomByID(Long id)
  {
    return classroomRepository.findById(id).get();
  }
  public Classroom saveClassroom(Classroom classrooms){
    return classroomRepository.save(classrooms);
  }


  public void deleteClassroom(Long id)
  {
    classroomRepository.findById(id)
      .map((classroom) -> classroom.getId())
      .ifPresent(classroomRepository::deleteById);

  }

  public void updateClassroom(Classroom classroom) {
    Classroom cr = classroomRepository.findById(classroom.getId())
      .orElseThrow(RuntimeException::new);

    cr.setName(classroom.getName());


  }

}
