package com.techpeak.faq.services;

import com.techpeak.faq.models.dto.FaqDto;
import com.techpeak.faq.models.dto.FaqRequest;

import java.util.List;

public interface FaqService {
  FaqDto create(FaqRequest request);
  List<FaqDto> listAll();
  FaqDto update(FaqRequest request, Long id);
  void delete(Long id);
}
