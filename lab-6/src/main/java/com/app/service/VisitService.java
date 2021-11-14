package com.app.service;

import com.app.domain.Visit;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.app.repo.VisitRepo;

@AllArgsConstructor
@Service
public class VisitService extends BaseService<Visit, Integer> {
    public VisitRepo repo;
    @Override
    protected JpaRepository<Visit, Integer> getRepository() { return repo; }
}
