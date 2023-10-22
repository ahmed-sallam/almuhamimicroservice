package com.techpeak.faq.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FaqDto {
  private Long id;
  private String questionAr;
  private  String questionEn;
  private String answerAr;
  private  String answerEn;
}
