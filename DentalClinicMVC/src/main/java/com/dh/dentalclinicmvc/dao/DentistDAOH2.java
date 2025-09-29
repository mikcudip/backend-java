package com.dh.dentalclinicmvc.dao;

import com.dh.dentalclinicmvc.model.Dentist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DentistDAOH2 implements IDAO<Dentist> {

  public static final String SQL_SAVE_DENTIST = "INSERT INTO dentists(firstName,lastName,registration) VALUES (?,?,?)";

  @Override
  public Dentist save(Dentist entity) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_DENTIST);
      preparedStatement.setString(1, entity.getFirstName());
      preparedStatement.setString(2, entity.getFirstName());
      preparedStatement.setLong(3, entity.getRegistration());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      try {
        connection.close();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    }
    return null;
  }

  @Override
  public Dentist findById(Long id) {
    return null;
  }

  @Override
  public void update(Dentist entity) {

  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Dentist> findAll() {
    return List.of();
  }

  @Override
  public Dentist findByString(String value) {
    return null;
  }
}
