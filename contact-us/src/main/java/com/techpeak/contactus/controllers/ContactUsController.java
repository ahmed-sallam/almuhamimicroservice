package com.techpeak.contactus.controllers;

import com.techpeak.contactus.models.ContactUsEntity;
import com.techpeak.contactus.models.dto.ContactUsDto;
import com.techpeak.contactus.models.dto.ContactUsRequest;
import com.techpeak.contactus.repositories.ContactUsRepository;
import com.techpeak.contactus.services.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact-us")
@RequiredArgsConstructor
public class ContactUsController {
  //todo: add validation
  // todo: add exception handling
  private final ContactUsService contactUsService;

  @PostMapping
  public ContactUsDto create(@RequestBody ContactUsRequest request, @RequestParam ("userId") Long userId){
    // todo: get userId from AuthService
    return contactUsService.create(request, userId);
  }
  @PostMapping("/{contactId}")
  public ContactUsDto create(@RequestBody ContactUsRequest request, @RequestParam ("userId") Long userId ,
                             @PathVariable("contactId")  Long contactId){
    // todo: get userId from AuthService
    return contactUsService.create(request, userId, contactId);
  }

  @GetMapping
  public Page<ContactUsEntity> listAll
      (@RequestParam(name = "page", defaultValue = "1") int page){
    int pageSize = 10;
    Pageable pageable = PageRequest.of(page, pageSize);
    return contactUsService.listAll(pageable);
  }

  @GetMapping("/{contactId}")
  public List<ContactUsDto> getOne( @PathVariable("contactId")Long contactId){
    return contactUsService.getOne(contactId);
  }
}
