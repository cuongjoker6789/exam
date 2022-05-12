package com.example.exam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "student")
public class Student extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int age;




  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="classroom_id", referencedColumnName = "id")
  @JsonBackReference
  private Classroom classroom;


}
