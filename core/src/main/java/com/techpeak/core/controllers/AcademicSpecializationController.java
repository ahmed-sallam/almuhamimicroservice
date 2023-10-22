package com.techpeak.core.controllers;

import com.techpeak.core.models.dto.BaseDto;
import com.techpeak.core.models.dto.BaseRequest;
import com.techpeak.core.services.BaseService;
import com.techpeak.core.services.impl.AcademicSpecializationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/core")
@RequiredArgsConstructor
public class AcademicSpecializationController {
  private final AcademicSpecializationServiceImpl baseService;
  @GetMapping("/academic")
  public List<BaseDto> listAll(){
    return baseService.listAll();
  }

  @PostMapping("/academic")
  public BaseDto create(@RequestBody BaseRequest request){
    return baseService.create(request);
  }

  @PutMapping("/academic/{id}")
  public BaseDto update(@RequestBody BaseRequest request, @PathVariable("id") Long id){
    return baseService.update(request, id);
  }
}
