package com.example.schoolservice.repository;

import com.example.schoolservice.entity.SchoolExcursion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<SchoolExcursion, Long> {
    List<SchoolExcursion> findByStandard(String standard);
}
