package com.dh.dentalclinicmvc.dao;

import com.dh.dentalclinicmvc.model.Address;
import com.dh.dentalclinicmvc.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOH2 implements IDAO<Patient> {
  public static final String SQL_SELECT_PATIENTS = "SELECT * FROM patients";
  public static final String SQL_DELETE_PATIENT_ID = "DELETE FROM patients WHERE id = ?";
  private AddressDAOH2 addressDAOH2 = new AddressDAOH2();
  public static final String SQL_INSERT_PATIENTS = "INSERT INTO patients (firstName, lastName, email, cardIdentity,admissionDate, address_id) VALUES (?, ?, ?, ?, ?, ?)";
  public static final String SQL_SELECT_PATIENT_ID = "SELECT * FROM patients WHERE id = ?";
  public static final String SQL_UPDATE_PATIENT_ID = "UPDATE patients SET firstName=?, lastName=?, email=?, cardIdentity=?, admissionDate=?, address_id=? WHERE id=?";
  public static final String SQL_SELECT_PATIENT_EMAIL = "SELECT * FROM patients WHERE email = ?";

  @Override
  public Patient save(Patient patient) {
    Connection connection = null;
    try {
      AddressDAOH2 addressDAOH2 = new AddressDAOH2();
      Address address = addressDAOH2.save(patient.getAddress());
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PATIENTS, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, patient.getFirstName());
      preparedStatement.setString(2, patient.getLastName());
      preparedStatement.setString(3, patient.getEmail());
      preparedStatement.setInt(4, patient.getCardIdentity());
      preparedStatement.setDate(5, Date.valueOf(patient.getAdmissionDate()));
      preparedStatement.setLong(6, patient.getAddress().getId());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()) {
        patient.setId(resultSet.getLong(1));
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
    return patient;
  }

  @Override
  public Patient findById(Long id) {
    Connection connection = null;
    Patient patient = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENT_ID);
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Address address = addressDAOH2.findById(resultSet.getLong(7));
        patient = new Patient(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6).toLocalDate(), address);
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
    return patient;
  }

  @Override
  public void update(Patient patient) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PATIENT_ID);
      preparedStatement.setString(1, patient.getFirstName());
      preparedStatement.setString(2, patient.getLastName());
      preparedStatement.setString(3, patient.getEmail());
      preparedStatement.setInt(4, patient.getCardIdentity());
      preparedStatement.setDate(5, Date.valueOf(patient.getAdmissionDate()));
      preparedStatement.setLong(6, patient.getAddress().getId());
      preparedStatement.setLong(7, patient.getId());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public void delete(Long id) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PATIENT_ID);
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
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

  @Override
  public List<Patient> findAll() {
    Connection connection = null;
    List<Patient> patients = new ArrayList<>();
    Patient patient = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Address address = addressDAOH2.findById(resultSet.getLong(7));
        patient = new Patient(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6).toLocalDate(), address);
        patients.add(patient);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return patients;
  }

  @Override
  public Patient findByString(String value) {
    Connection connection = null;
    Patient patient = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENT_EMAIL);
      preparedStatement.setString(1, value);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Address address = addressDAOH2.findById(resultSet.getLong(7));
        patient = new Patient(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDate(6).toLocalDate(), address);
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
    return patient;
  }
}
