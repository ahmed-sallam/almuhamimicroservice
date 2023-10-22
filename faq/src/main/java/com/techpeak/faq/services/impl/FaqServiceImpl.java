package com.techpeak.faq.services.impl;

import com.techpeak.faq.models.FaqEntity;
import com.techpeak.faq.models.dto.FaqDto;
import com.techpeak.faq.models.dto.FaqRequest;
import com.techpeak.faq.repositories.FaqRepository;
import com.techpeak.faq.services.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {
  private final FaqRepository faqRepository;
  
  @Override
  public FaqDto create(FaqRequest request) {
    FaqEntity entity = faqRepository.save(toEntity(request));
    return toDto(entity);
  }

  private FaqDto toDto(FaqEntity entity) {
    return FaqDto.builder()
        .id(entity.getId())
        .questionAr(entity.getQuestionAr())
        .questionEn(entity.getQuestionEn())
        .answerAr(entity.getAnswerAr())
        .answerEn(entity.getAnswerEn())
        .build();
  }

  private FaqEntity toEntity(FaqRequest request) {
    return FaqEntity.builder()
        .questionAr(request.getQuestionAr())
        .questionEn(request.getQuestionEn())
        .answerAr(request.getAnswerAr())
        .answerEn(request.getAnswerEn())
        .build();
  }

  @Override
  public List<FaqDto> listAll() {
    List<FaqEntity> entities = faqRepository.findAll();
    return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
  }

  @Override
  public FaqDto update(FaqRequest request, Long id) {
    FaqEntity entity = toEntity(request);
    entity.setId(id);
    FaqEntity newEntity = faqRepository.save(entity);
    return toDto(newEntity);

  }

  @Override
  public void delete(Long id) {
// todo
  }
}
