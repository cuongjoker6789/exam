package com.example.exam.service;

import com.example.exam.entity.Student;
import com.example.exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


//  @Autowired
//  private ModelMapper modelMapper;
  @Autowired
  private StudentRepository studentRepository;

  public List<Student> get() {
    return studentRepository.findAll();
  }

  public Student getStudentByID(Long id)
  {
    return studentRepository.findById(id).get();
  }
  public Student saveStudent(Student students){
    return studentRepository.save(students);
  }


  public void delete(Long id)
  {
    studentRepository.findById(id)
      .map((student) -> student.getId())
      .ifPresent(studentRepository::deleteById);

  }

//  public void update(StudentDTO studentDTO) {
//    Student student = modelMapper.map(studentDTO,Student.class);
//
//    update(student);
//  }


  public void update(Student student) {
    Student st = studentRepository.findById(student.getId())
      .orElseThrow(RuntimeException::new)
      ;

    st.setName(student.getName());
    st.setAge(student.getAge());

  }

  public List<Student> getAllStudentByClassroomId(int id) {
    return StudentRepository.findAllByClassroom_Id(id);
  }

}
