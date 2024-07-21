package com.crm.demo.rest;

import com.crm.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theeStudents;
    @PostConstruct
    public void loadTheDate(){
        theeStudents=new ArrayList<>();
        theeStudents.add(new Student("fatma","mostafe"));
        theeStudents.add(new Student("farha","mostafe"));
        theeStudents.add(new Student("abdo","mostafe"));
    }
    //define endpoint for / students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theeStudents;
    }
    //define end point or "/students/{studentId}" -return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudnt(@PathVariable int studentId){
        if((studentId>theeStudents.size())||(studentId<0)){
            throw new studentNoteFoundException("student not found - "+studentId);
        }
        return  theeStudents.get(studentId);
    }



}
