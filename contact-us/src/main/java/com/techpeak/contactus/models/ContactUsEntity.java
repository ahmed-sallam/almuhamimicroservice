package com.techpeak.contactus.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_us")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long senderId;
  private String subject;
  private String message;
  private Long parentId;
  private LocalDateTime createdAt = LocalDateTime.now();
}
