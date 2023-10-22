package com.techpeak.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "issue_categories")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueCategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nameAr;
  private  String nameEn;
}
