package com.techpeak.core.services.impl;

import com.techpeak.core.models.AcademicSpecializationEntity;
import com.techpeak.core.models.dto.BaseDto;
import com.techpeak.core.models.dto.BaseRequest;
import com.techpeak.core.repositories.AcademicSpecializationRepository;
import com.techpeak.core.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcademicSpecializationServiceImpl implements BaseService {
  private final AcademicSpecializationRepository academicSpecializationRepository;

  private BaseDto toDto(AcademicSpecializationEntity entity){
    return BaseDto.builder()
        .id(entity.getId())
        .nameAr(entity.getNameAr())
        .nameEn(entity.getNameEn())
        .build();
  }

  private AcademicSpecializationEntity toEntity(BaseRequest request){
    return AcademicSpecializationEntity.builder()
        .nameAr(request.getNameAr())
        .nameEn(request.getNameEn())
        .build();
  }

  @Override
  public BaseDto create(BaseRequest request) {
    AcademicSpecializationEntity entity = toEntity(request);
    AcademicSpecializationEntity newEntity = academicSpecializationRepository.save(entity);
    return toDto(newEntity);
  }

  @Override
  public List<BaseDto> listAll() {
    List<AcademicSpecializationEntity> entities = academicSpecializationRepository.findAll();
    return entities.stream().map(e->toDto(e)).collect(Collectors.toList());
  }

  @Override
  public BaseDto update(BaseRequest request, Long id) {
    AcademicSpecializationEntity entity = toEntity(request);
      entity.setId(id);
    AcademicSpecializationEntity newEntity = academicSpecializationRepository.save(entity);
    return toDto(newEntity);
  }

  @Override
  public void delete(Long id) {
  // todo;
  }
}
