package com.example.student.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentJpaRepo extends JpaRepository<Student,Integer>, PagingAndSortingRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
}
