package com.techpeak.contactus.services;

import com.techpeak.contactus.models.ContactUsEntity;
import com.techpeak.contactus.models.dto.ContactUsDto;
import com.techpeak.contactus.models.dto.ContactUsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactUsService {

  ContactUsDto create(ContactUsRequest request, Long userId);
  ContactUsDto create(ContactUsRequest request, Long userId, Long contactId);
  Page<ContactUsEntity> listAll(Pageable pageable);

  List<ContactUsDto> getOne( Long contactId);

}
