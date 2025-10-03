package com.dh.dentalclinicmvc.dao;

import com.dh.dentalclinicmvc.model.Dentist;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DentistDAOH2 implements IDAO<Dentist> {

  public static final String SQL_INSERT_DENTIST = "INSERT INTO dentists(firstName,lastName,registration) VALUES (?,?,?)";
  public static final String SQL_SELECT_DENTIST_ID = "SELECT * FROM dentists WHERE id = ?";
  public static final String SQL_DELETE_DENTIST_ID = "DELETE FROM dentists WHERE id=?";
  public static final String SQL_SELECT_DENTISTS_ALL = "SELECT * FROM dentists";
  public static final String SQL_UPDATE_DENTIST_ID = "UPDATE dentists SET firstName=?,lastName=?,registration=? WHERE id=?";

  @Override
  public Dentist save(Dentist dentist) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_DENTIST, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, dentist.getFirstName());
      preparedStatement.setString(2, dentist.getLastName());
      preparedStatement.setLong(3, dentist.getRegistration());
      preparedStatement.execute();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()) {
        dentist.setId(resultSet.getLong(1));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dentist;
  }

  @Override
  public Dentist findById(Long id) {
    Connection connection = null;
    Dentist dentist = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DENTIST_ID);
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        dentist = new Dentist(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dentist;
  }

  @Override
  public void update(Dentist dentist) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_DENTIST_ID);
      preparedStatement.setString(1, dentist.getFirstName());
      preparedStatement.setString(2, dentist.getFirstName());
      preparedStatement.setLong(3, dentist.getRegistration());
      preparedStatement.setLong(4, dentist.getId());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void delete(Long id) {
    Connection connection = null;
    try {
      connection =DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_DENTIST_ID);
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }  finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public List<Dentist> findAll() {
    Connection connection = null;
    List<Dentist> dentists = new ArrayList<>();
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DENTISTS_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        dentists.add(new Dentist(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dentists;
  }

  @Override
  public Dentist findByString(String value) {
    return null;
  }
}
