package com.example.exam.entity;

import com.example.exam.listener.AuditListener;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditListener.class)
public class Auditable {

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime modifiedAt;
}
