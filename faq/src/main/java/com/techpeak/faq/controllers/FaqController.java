package com.techpeak.faq.controllers;

import com.techpeak.faq.models.dto.FaqDto;
import com.techpeak.faq.models.dto.FaqRequest;
import com.techpeak.faq.services.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faq")
@RequiredArgsConstructor
public class FaqController {
  private final FaqService faqService;

  @PostMapping
  public FaqDto create(@RequestBody FaqRequest request){
    return faqService.create(request);
  }

  @PutMapping("/{id}")
  public FaqDto update(@RequestBody FaqRequest request, @PathVariable("id") Long id){
    return faqService.update(request, id);
  }

  @GetMapping
  public List<FaqDto> listAll(){
    return faqService.listAll();
  }
}
