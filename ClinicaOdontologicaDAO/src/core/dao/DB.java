package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
  public static final String SQL_TABLE_CREATE_DENTIST = "DROP TABLE IF EXISTS dentists;" +
      "CREATE TABLE DENTIST" +
      "(" +
      "id INT AUTO_INCREMENT PRIMARY KEY," +
      "registration INT NOT NULL," +
      "firstName VARCHAR(100) NOT NULL," +
      "lastName VARCHAR(100) NOT NULL," +
      ")";
  public static final String SQL_TABLE_CREATE_PATIENT = "DROP TABLE IF EXISTS patients;" +
      "CREATE TABLE DENTIST" +
      "(" +
      "id INT AUTO_INCREMENT PRIMARY KEY," +
      "firstName VARCHAR(100) NOT NULL," +
      "lastName VARCHAR(100) NOT NULL," +
      "cardIdentity VARCHAR(100) NOT NULL," +
      "admissionDate DATETIME NOT NULL," +
      ")";

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:~/ClinicaOdontologicaDAO");
  }

  public static Boolean createTables() {
    Connection connection = null;
    try {
      connection = getConnection();
      Statement statement = connection.createStatement();
      statement.execute(SQL_TABLE_CREATE_DENTIST);
      statement.execute(SQL_TABLE_CREATE_PATIENT);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return true;
  }
}
