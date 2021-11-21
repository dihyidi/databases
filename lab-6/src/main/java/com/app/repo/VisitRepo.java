package com.app.repo;

import com.app.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit, Integer> {
}
