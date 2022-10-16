package com.app.controller;

import com.app.domain.Visit;
import com.app.dto.VisitDto;
import lombok.AllArgsConstructor;
import com.app.mapper.BaseMapper;
import com.app.mapper.VisitMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.BaseService;
import com.app.service.VisitService;

@RequestMapping(value = "/visits")
@RestController
@AllArgsConstructor
public class VisitController extends com.app.controller.BaseController<Visit, VisitDto, Integer> {
    private final VisitService service;
    private final VisitMapper mapper;

    @Override
    protected BaseService<Visit, Integer, VisitDto> getService() {
        return service;
    }

    @Override
    protected BaseMapper<Visit, VisitDto> getMapper() {
        return mapper;
    }
}
