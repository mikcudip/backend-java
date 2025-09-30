package com.dh.dentalclinicmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

  public static final String DRIVER = "org.h2.Driver";
  public static final String URL = "jdbc:h2:mem:test";
  public static final String USER = "sa";
  public static final String PASSWORD = "sa";

  public static Connection getConnection() throws Exception {
    Class.forName(DRIVER);
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables() {
    Connection connection = null;
    try {
      connection = getConnection();
      Statement statement = connection.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
