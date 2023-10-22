package com.techpeak.core.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BaseDto {
  private Long id;
  private String nameAr;
  private  String nameEn;
}
