package com.example.exam.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "classroom")
public class Classroom extends  Auditable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)

  @JsonManagedReference
  private List<Student> students;

}
