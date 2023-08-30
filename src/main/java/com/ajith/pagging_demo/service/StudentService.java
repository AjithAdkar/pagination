package com.ajith.pagging_demo.service;

import com.ajith.pagging_demo.model.Student;
import com.ajith.pagging_demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Page<Student> getAllStudent(int i) {
        return studentRepo.findAll(PageRequest.of(i, 10));
    }

}
