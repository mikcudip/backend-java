package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOH2 implements IDAO<Student> {
  private final static String DB_JDBC_DRIVER = "org.h2.Driver";
  private final static String DB_URL = "jdbc:h2:~/test";
  private final static String DB_USER = "sa";
  private final static String DB_PASSWORD = "";
  private final static String DB_SELECT_ID = "SELECT id, firstName, lastName FROM student WHERE id = ?";
  private final static String DB_DELETE_ID = "DELETE FROM student WHERE id = ?";
  private final static String DB_SELECT_ALL = "SELECT id, firstName, lastName FROM student";


  @Override
  public Student save(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      Class.forName(DB_JDBC_DRIVER);
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

      preparedStatement = connection.prepareStatement("INSERT INTO student VALUES(?,?,?)");
      preparedStatement.setLong(1, student.getId());
      preparedStatement.setString(2, student.getFirstName());
      preparedStatement.setString(3, student.getLastName());

      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return student;
  }

  @Override
  public Boolean delete(Long id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      Class.forName(DB_JDBC_DRIVER);
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

      preparedStatement = connection.prepareStatement(DB_DELETE_ID);
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Student find(Long id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Student student = null;

    try {
      Class.forName(DB_JDBC_DRIVER);
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      preparedStatement = connection.prepareStatement(DB_SELECT_ID);
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Long idStudent = resultSet.getLong("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        student = new Student(idStudent, firstName, lastName);
      }
      preparedStatement.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return student;
  }

  @Override
  public List<Student> findAll() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    List<Student> students = new ArrayList<>();

    try {
      Class.forName(DB_JDBC_DRIVER);
      connection = DriverManager.getConnection(DB_URL, "sa", "sa");
      preparedStatement = connection.prepareStatement(DB_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Long idStudent = resultSet.getLong("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        students.add(new Student(idStudent, firstName, lastName));
      }
      preparedStatement.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return students;
  }
}
