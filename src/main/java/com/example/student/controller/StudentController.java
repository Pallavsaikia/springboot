package com.example.student.controller;


import com.example.student.PaginationObject;
import com.example.student.SuccessResponse;
import com.example.student.model.Student;
import com.example.student.model.StudentDTO;
import com.example.student.model.StudentJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentJpaRepo studentJpaRepo;


    @PostMapping(value = "/student")
    public ResponseEntity<Object> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student s = new Student();
        s.setAge(studentDTO.getAge());
        s.setName(studentDTO.getName());
        studentJpaRepo.save(s);
        SuccessResponse sr=new SuccessResponse(true,"added",null);
        return new ResponseEntity<>(sr, HttpStatus.OK);

    }

    @GetMapping(value = "/student")
    public ResponseEntity<Object> getAllStudent(Pageable pageable) {
        Page<Student> page =studentJpaRepo.findAll(pageable);
        PaginationObject po=new PaginationObject<Student>(page.getContent(),page.getTotalPages());
        SuccessResponse sr=new SuccessResponse(true,"All List",po);
        return new ResponseEntity<>(sr, HttpStatus.OK);

    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Object> getStudent(@Valid @PathVariable  Integer id) {
        Student s =studentJpaRepo.findById(id).orElse(null);
        SuccessResponse sr=new SuccessResponse(true,"One Student",s);
        return new ResponseEntity<>(sr, HttpStatus.OK);

    }

    @DeleteMapping(value = "/student/{id}")
    public ResponseEntity<Object> deletetStudent(@Valid @PathVariable  Integer id) {
        Student s =studentJpaRepo.findById(id).orElse(null);
        if(s!=null){
            studentJpaRepo.delete(s);
            SuccessResponse sr=new SuccessResponse(true,"successfully removed",null);
            return new ResponseEntity<>(sr, HttpStatus.OK);
        }else{
            SuccessResponse sr=new SuccessResponse(false,"no student found",null);
            return new ResponseEntity<>(sr, HttpStatus.OK);
        }


    }


    @PutMapping(value = "/student/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable  Integer id, @RequestBody StudentDTO studentDTO) {
        Student s = new Student();
        s.setId(id);
        s.setAge(studentDTO.getAge());
        s.setName(studentDTO.getName());
        studentJpaRepo.save(s);
        SuccessResponse sr=new SuccessResponse(true,"added",null);
        return new ResponseEntity<>(sr, HttpStatus.OK);

    }
}
