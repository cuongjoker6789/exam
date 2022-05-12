package com.example.exam.listener;

import com.example.exam.entity.Auditable;
import lombok.Data;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
@Data
public class AuditListener {


  @PrePersist
  public void prePersist(Object object){
    if(object instanceof Auditable) {
      Auditable auditable = (Auditable) object;
      auditable.setCreatedAt(LocalDateTime.now());
      auditable.setModifiedAt(LocalDateTime.now());
    }
  }

  @PreUpdate
  public void preUpdate(Object object){
    if(object instanceof Auditable) {
      Auditable auditable = (Auditable) object;
      auditable.setModifiedAt(LocalDateTime.now());
    }
  }



//  @PrePersist
//  private void prePersist(Object object) {
//    if(object instanceof Student) {
//      Student student = (Student) object;
//      student.setCreatedAt(LocalDateTime.now());
//    }
//  }
//  @PreUpdate
//  private void preUpdate(Object object){
//    if(object instanceof Student) {
//      Student student = (Student) object;
//      student.setModifiedAt(LocalDateTime.now());
//    }
//  }
}
