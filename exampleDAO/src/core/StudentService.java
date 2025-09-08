package core;

import java.util.List;

public class StudentService {
  private IDAO<Student> studentDAO;

  public StudentService() {
    this.studentDAO = new StudentDAOH2();
  }

  public StudentService(IDAO<Student> studentDAO) {
    this.studentDAO = studentDAO;
  }

  public void setStudent(IDAO<Student> studentDAO) {
    this.studentDAO = studentDAO;
  }

  public Student save(Student student) {
    return this.studentDAO.save(student);
  }

  public Boolean delete(Long id) {
    return this.studentDAO.delete(id);
  }

  public Student find(Long id) {
    return studentDAO.find(id);
  }

  public List<Student> findAll() {
    return studentDAO.findAll();
  }
}
