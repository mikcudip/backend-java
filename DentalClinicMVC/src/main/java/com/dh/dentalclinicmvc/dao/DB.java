package com.dh.dentalclinicmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

  public static final String DRIVER = "org.h2.Driver";
  public static final String URL = "jdbc:h2:mem:test";
  public static final String USER = "sa";
  public static final String PASSWORD = "sa";
  public static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS addresses;" +
      "CREATE TABLE addresses(id INT AUTO_INCREMENT PRIMARY KEY," +
      "street varchar(100) NOT NULL," +
      "number INT NOT NULL," +
      "location varchar(100) NOT NULL," +
      "province varchar(100) NOT NULL);";
  public static final String SQL_DROP_CREATE_PATIENTS = "DROP TABLE IF EXISTS patients;" +
      "CREATE TABLE patients(id INT AUTO_INCREMENT PRIMARY KEY," +
      "firstName varchar(100) NOT NULL," +
      "lastName varchar(100) NOT NULL," +
      "email varchar(100) NOT NULL," +
      "cardIdentity INT NOT NULL," +
      "admissionDate DATE NOT NULL," +
      "address_id INT NOT NULL);";
  public static final String SQL_DROP_CREATE_DENTISTS = "DROP TABLE IF EXISTS dentists;" +
      "CREATE TABLE dentists(id INT AUTO_INCREMENT PRIMARY KEY," +
      "firstName varchar(100) NOT NULL," +
      "lastName varchar(100) NOT NULL," +
      "registration INT NOT NULL);";
  public static final String SQL_INSERT_INITIALIZE = "INSERT INTO addresses(street, number, location, province)" +
      "VALUES ('Calle A', 101, 'Luján de Cuyo', 'Mendoza');" +
      "INSERT INTO patients(firstName, lastName, email, cardIdentity, admissionDate, address_id)" +
      "VALUES ('Mik', 'Cudi', 'mikcudip@gmail.com', 72474322, '2023-11-10', 1);" +
      "INSERT INTO dentists(firstName, lastName, registration)" +
      "VALUES ('Doctor', 'Cudi', 123);";

  public static Connection getConnection() throws Exception {
    Class.forName(DRIVER);
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables() {
    Connection connection = null;
    try {
      connection = getConnection();
      Statement statement = connection.createStatement();
      statement.executeUpdate(SQL_DROP_CREATE_DENTISTS);
      statement.executeUpdate(SQL_DROP_CREATE_ADDRESSES);
      statement.executeUpdate(SQL_DROP_CREATE_PATIENTS);
      statement.executeUpdate(SQL_INSERT_INITIALIZE);
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
