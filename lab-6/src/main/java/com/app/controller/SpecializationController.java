package com.app.controller;

import com.app.domain.Specialization;
import com.app.dto.SpecializationDto;
import lombok.AllArgsConstructor;
import com.app.mapper.BaseMapper;
import com.app.mapper.SpecializationMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.BaseService;
import com.app.service.SpecializationService;

@RequestMapping(value = "/specializations")
@RestController
@AllArgsConstructor
public class SpecializationController extends BaseController<Specialization, SpecializationDto, Integer> {
    private final SpecializationService service;
    private final SpecializationMapper mapper;

    @Override
    protected BaseService<Specialization, Integer, SpecializationDto> getService() {
        return service;
    }

    @Override
    protected BaseMapper<Specialization, SpecializationDto> getMapper() {
        return mapper;
    }
}
