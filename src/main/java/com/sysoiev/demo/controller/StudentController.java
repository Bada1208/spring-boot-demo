package com.sysoiev.demo.controller;

import com.sysoiev.demo.model.Student;
import com.sysoiev.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}"
    )
    public void deleteStudentById(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudentById(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
        studentService.updateStudentById(studentId, student);
    }

}
