package com.techpeak.core.services;

import com.techpeak.core.models.dto.BaseDto;
import com.techpeak.core.models.dto.BaseRequest;

import java.util.List;

public interface BaseService {
BaseDto create(BaseRequest request);
List<BaseDto> listAll();
BaseDto update(BaseRequest request, Long id);
void delete(Long id);
}
