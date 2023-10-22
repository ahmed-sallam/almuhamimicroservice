package com.techpeak.contactus.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactUsDto {
  private Long id;
  private Long senderId;
  private String subject;
  private String message;
  private Long parentId;
  private LocalDateTime createdAt;
}
