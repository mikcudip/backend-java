package com.dh.testdb.service;

import com.dh.testdb.entity.Student;
import com.dh.testdb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  public Student save(Student student) {
    return studentRepository.save(student);
  }
}
