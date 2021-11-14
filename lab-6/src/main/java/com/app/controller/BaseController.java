package com.app.controller;

import com.app.mapper.BaseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.service.BaseService;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseController<TEntity, TDto, TId> {
    protected abstract BaseService<TEntity, TId> getService();
    protected abstract BaseMapper<TEntity, TDto> getMapper();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<TDto>> getAll() {
        List<TEntity> entities = getService().getAll();
        List<TDto> entityDtos = new ArrayList<>();
        for (TEntity entity : entities) {
            entityDtos.add(getMapper().mapEntityToDto(entity));
        }
        return new ResponseEntity<>(entityDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody
    ResponseEntity<TDto> getById(@PathVariable TId id){
        TEntity entity = getService().getById(id);
        if(entity == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            return new ResponseEntity<>(getMapper().mapEntityToDto(entity), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<Void> create(@RequestBody TEntity newEntity) {
        getService().create(newEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<TEntity> update(@PathVariable TId id, @RequestBody TEntity entity) {
        if (getService().getById(id) != null) {
            getService().update(id, entity);
            return new ResponseEntity<>(getService().update(id, entity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable TId id) {
        if (getService().getById(id) != null) {
            getService().deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
