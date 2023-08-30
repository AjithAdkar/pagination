package com.ajith.pagging_demo.repository;

import com.ajith.pagging_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository< Student,Integer> {

}
