package com.app.controller;

import com.app.domain.Diagnosis;
import com.app.dto.DiagnosisDto;
import lombok.AllArgsConstructor;
import com.app.mapper.BaseMapper;
import com.app.mapper.DiagnosisMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.BaseService;
import com.app.service.DiagnosisService;

@RequestMapping(value = "/diagnoses")
@RestController
@AllArgsConstructor
public class DiagnosisController extends BaseController<Diagnosis, DiagnosisDto, Integer> {
    private final DiagnosisService service;
    private final DiagnosisMapper mapper;

    @Override
    protected BaseService<Diagnosis, Integer, DiagnosisDto> getService() {
        return service;
    }

    @Override
    protected BaseMapper<Diagnosis, DiagnosisDto> getMapper() {
        return mapper;
    }
}
