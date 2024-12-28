package com.example.schoolservice.service.impl;

import com.example.schoolservice.entity.SchoolExcursion;
import com.example.schoolservice.repository.SchoolRepository;
import com.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<SchoolExcursion> getAllRegistrations() {

        return schoolRepository.findAll();
    }
}
