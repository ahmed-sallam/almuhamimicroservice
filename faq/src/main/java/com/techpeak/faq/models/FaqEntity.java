package com.techpeak.faq.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "faqs")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaqEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String questionAr;
  private  String questionEn;
  private String answerAr;
  private  String answerEn;
}
