package com.app.controller;

import com.app.domain.Patient;
import com.app.dto.PatientDto;
import lombok.AllArgsConstructor;
import com.app.mapper.BaseMapper;
import com.app.mapper.PatientMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.BaseService;
import com.app.service.PatientService;

@RequestMapping(value = "/patients")
@RestController
@AllArgsConstructor
public class PatientController extends BaseController<Patient, PatientDto, Integer> {
    private final PatientService service;
    private final PatientMapper mapper;

    @Override
    protected BaseService<Patient, Integer, PatientDto> getService() {
        return service;
    }

    @Override
    protected BaseMapper<Patient, PatientDto> getMapper() {
        return mapper;
    }
}
