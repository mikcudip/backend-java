package com.dh.testdb.controller;

import com.dh.testdb.entity.Student;
import com.dh.testdb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/all")
  public List<Student> findAll() {
    return studentService.findAll();
  }

  @PostMapping("/save")
  public Student save(@RequestBody Student student) {
    return studentService.save(student);
  }
}
