package core;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
  private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS ANIMALS;" +
      "CREATE TABLE ANIMALS(" +
      "id INT PRIMARY KEY," +
      "name VARCHAR(50) NOT NULL," +
      "type VARCHAR(50) NOT NULL)";

  private static final String SQL_INSERT = "INSERT INTO ANIMALS VALUES (1,'Molly','cat')," +
      "(2,'Helga','dog')," +
      "(3,'Melba','dog')," +
      "(4,'Rocky','turtle')";

  private static final String SQL_SELECT = "SELECT * FROM ANIMALS";

  private static final String SQL_DELETE = "DELETE FROM ANIMALS WHERE id = 4";

  private static final Logger LOGGER = Logger.getLogger(Animal.class);

  public static void main(String[] args) {
    Connection connection = null;
    try {
      // Conectarnos a la BD
      connection = getConnection();

      // Ordenes a la BD
      Statement statement = connection.createStatement();

      // Crear la tabla
      statement.execute(SQL_DROP_CREATE);

      // Insertar valores
      statement.execute(SQL_INSERT);

      // Consultas a la BD
      ResultSet resultSet = statement.executeQuery(SQL_SELECT);

      while (resultSet.next()) {
        System.out.printf("Id: " + resultSet.getString(1) + "\nName: " + resultSet.getString(2) + "\nType: " + resultSet.getString(3) + "\n----------\n");
        LOGGER.info("Id: " + resultSet.getString(1) + "\nName: " + resultSet.getString(2) + "\nType: " + resultSet.getString(3) + "\n----------\n");
      }

      statement.execute(SQL_DELETE);
      LOGGER.info("WARNING: Animal has been deleted");

      resultSet = statement.executeQuery(SQL_SELECT);

      while (resultSet.next()) {
        System.out.printf("Id: " + resultSet.getString(1) + "\nName: " + resultSet.getString(2) + "\nType: " + resultSet.getString(3) + "\n----------\n");
        LOGGER.info("Id: " + resultSet.getString(1) + "\nName: " + resultSet.getString(2) + "\nType: " + resultSet.getString(3) + "\n----------\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Close Connection
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
  }
}
