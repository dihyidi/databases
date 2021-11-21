package com.app.controller;

import com.app.domain.Doctor;
import com.app.dto.DoctorDto;
import lombok.AllArgsConstructor;
import com.app.mapper.BaseMapper;
import com.app.mapper.DoctorMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.BaseService;
import com.app.service.DoctorService;

@RequestMapping(value = "/doctors")
@RestController
@AllArgsConstructor
public class DoctorController extends BaseController<Doctor, DoctorDto, Integer> {
    private final DoctorService service;
    private final DoctorMapper mapper;

    @Override
    protected BaseService<Doctor, Integer, DoctorDto> getService() {
        return service;
    }

    @Override
    protected BaseMapper<Doctor, DoctorDto> getMapper() {
        return mapper;
    }
}
