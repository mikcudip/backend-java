package core;

import java.util.List;

public class StudentDAOInMemory implements IDAO<Student> {
  private List<Student> studentRepository;

  public StudentDAOInMemory(List<Student> studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student save(Student student) {
    studentRepository.add(student);
    return student;
  }

  @Override
  public Boolean delete(Long id) {
    Student student = find(id);
    return studentRepository.remove(student);
  }

  @Override
  public Student find(Long id) {
    for (Student student : studentRepository) {
      if (student.getId().equals(id)) {
        return student;
      }
    }
    return null;
  }

  @Override
  public List<Student> findAll() {
    return studentRepository;
  }
}
