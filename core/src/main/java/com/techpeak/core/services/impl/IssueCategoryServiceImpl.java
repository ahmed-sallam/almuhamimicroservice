package com.techpeak.core.services.impl;

import com.techpeak.core.models.IssueCategoryEntity;
import com.techpeak.core.models.dto.BaseDto;
import com.techpeak.core.models.dto.BaseRequest;
import com.techpeak.core.repositories.IssueCategoryRepository;
import com.techpeak.core.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueCategoryServiceImpl implements BaseService {
  private final IssueCategoryRepository issueCategoryRepository;

  private BaseDto toDto(IssueCategoryEntity entity){
    return BaseDto.builder()
        .id(entity.getId())
        .nameAr(entity.getNameAr())
        .nameEn(entity.getNameEn())
        .build();
  }

  private IssueCategoryEntity toEntity(BaseRequest request){
    return IssueCategoryEntity.builder()
        .nameAr(request.getNameAr())
        .nameEn(request.getNameEn())
        .build();
  }

  @Override
  public BaseDto create(BaseRequest request) {
    IssueCategoryEntity entity = toEntity(request);
    IssueCategoryEntity newEntity = issueCategoryRepository.save(entity);
    return toDto(newEntity);
  }

  @Override
  public List<BaseDto> listAll() {
    List<IssueCategoryEntity> entities = issueCategoryRepository.findAll();
    return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
  }

  @Override
  public BaseDto update(BaseRequest request, Long id) {
    IssueCategoryEntity entity = toEntity(request);
      entity.setId(id);
    IssueCategoryEntity newEntity = issueCategoryRepository.save(entity);
    return toDto(newEntity);
  }

  @Override
  public void delete(Long id) {
  // todo;
  }
}
