package com.app.repo;

import com.app.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
