package com.techpeak.contactus.services.impl;

import com.techpeak.contactus.models.ContactUsEntity;
import com.techpeak.contactus.models.dto.ContactUsDto;
import com.techpeak.contactus.models.dto.ContactUsRequest;
import com.techpeak.contactus.repositories.ContactUsRepository;
import com.techpeak.contactus.services.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactUsServiceImpl implements ContactUsService {
  private final ContactUsRepository contactUsRepository;
  @Override
  public ContactUsDto create(ContactUsRequest request, Long userId) {
    ContactUsEntity entity = toEntity(request, userId);
    ContactUsEntity newEntity = contactUsRepository.save(entity);
    return toDto(newEntity);
  }

  private ContactUsEntity toEntity(ContactUsRequest request, Long userId) {
    return ContactUsEntity.builder()
        .senderId(userId)
        .subject(request.getSubject())
        .message(request.getMessage())
        .build();
  }

  private ContactUsDto toDto(ContactUsEntity newEntity) {
   return ContactUsDto.builder()
        .id(newEntity.getId())
        .senderId(newEntity.getSenderId())
        .message(newEntity.getMessage())
        .parentId(newEntity.getParentId())
        .createdAt(newEntity.getCreatedAt())
        .build();
  }

  @Override
  public ContactUsDto create(ContactUsRequest request, Long userId, Long contactId) {
    ContactUsEntity entity = toEntity(request, userId);
    entity.setParentId(contactId);
    ContactUsEntity newEntity = contactUsRepository.save(entity);
    return toDto(newEntity);
  }

  @Override
  public Page<ContactUsEntity> listAll(Pageable pageable) {
    Page<ContactUsEntity> allByParentIdIsNull = contactUsRepository.findAllByParentIdIsNull(pageable);
    return allByParentIdIsNull;
    // todo: refactor to dto
  }

  @Override
  public List<ContactUsDto> getOne(Long contactId) {
    List<ContactUsEntity> all = contactUsRepository.findByParentIdOrderByCreatedAt(contactId);
    return all.stream().map(e->toDto(e)).collect(Collectors.toList());  }
}
