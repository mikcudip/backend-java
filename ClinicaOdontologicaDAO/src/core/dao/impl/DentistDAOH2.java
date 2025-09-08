package core.dao.impl;

import core.dao.DB;
import core.dao.IDAO;
import core.model.Dentist;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDAOH2 implements IDAO<Dentist> {
  private static final Logger LOGGER = Logger.getLogger(DentistDAOH2.class);
  private static final String SQL_INSERT = "INSERT INTO dentists (registration, firstName, lastName)" +
      "VALUES (?, ?, ?)";
  public static final String SQL_SELECT_ID = "SELECT * FROM dentists WHERE id = ?";
  public static final String SQL_UPDATE_ID = "UPDATE dentists SET registration = ?, firstName = ?, lastName = ? WHERE id = ?";
  public static final String SQL_DELETE_ID = "DELETE FROM dentists WHERE id = ?";
  public static final String SQL_SELECT_ALL = "SELECT * FROM dentists";

  @Override
  public Dentist save(Dentist dentist) {
    Connection connection = null;
    try {
      LOGGER.info("Se inició una operación de guardado de odontólogo.");
      connection = DB.getConnection();
      PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
      psInsert.setLong(1, dentist.getRegistration());
      psInsert.setString(2, dentist.getFirstName());
      psInsert.setString(3, dentist.getLastName());
      psInsert.execute();

      ResultSet rs = psInsert.getGeneratedKeys();
      while (rs.next()) {
        dentist.setId(rs.getLong(1));
        LOGGER.info("INFO: Este es el odontólogo que se guardó: " + dentist.getFirstName() + " " + dentist.getLastName());
      }
    } catch (Exception e) {
      LOGGER.error("WARN: " + e);
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        LOGGER.error("ERROR: " + e);
        e.printStackTrace();
      }
    }
    return dentist;
  }

  @Override
  public Boolean update(Dentist dentist) {
    Boolean result = false;
    LOGGER.info("INFO: Iniciando la actualización de un odontólogo.");
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE_ID);
      psUpdate.setLong(1, dentist.getRegistration());
      psUpdate.setString(2, dentist.getFirstName());
      psUpdate.setString(3, dentist.getLastName());
      psUpdate.setLong(4, dentist.getId());
      psUpdate.execute();
    } catch (Exception e) {
      result = false;
      LOGGER.error("ERROR: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        result = false;
        LOGGER.error("ERROR: " + e.getMessage());
        e.printStackTrace();
      }
    }
    return result;
  }

  @Override
  public Boolean delete(Long id) {
    Boolean result = true;
    LOGGER.warn("WARN: Iniciando la eliminación del odontólogo con id: " + id);
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE_ID);
      psDelete.setLong(1, id);
      psDelete.execute();
      LOGGER.warn("WARN: Se eliminó el odontólogo con id: " + id);
    } catch (Exception e) {
      result = false;
      LOGGER.error("ERROR: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        result = false;
        LOGGER.error("ERROR: " + e.getMessage());
      }
    }
    return result;
  }

  @Override
  public Dentist findById(Long id) {
    Connection connection = null;
    LOGGER.info("INFO: Iniciando la búsqueda de un odontólogo.");
    Dentist dentist = null;
    try {
      connection = DB.getConnection();
      PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT_ID);
      psSelect.setLong(1, id);
      ResultSet rs = psSelect.executeQuery();
      while (rs.next()) {
        dentist = new Dentist(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4));
        LOGGER.info("INFO: Consultamos el odontólogo con id: " + dentist.getId() + " es: " + dentist);
      }
    } catch (Exception e) {
      LOGGER.error("ERROR: " + e);
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        LOGGER.error("ERROR: " + e.getMessage());
        e.printStackTrace();
      }
    }
    return dentist;
  }

  @Override
  public List<Dentist> findAll() {
    Connection connection = null;
    LOGGER.info("INFO: Iniciando la búsqueda de todos los odontólogos.");
    List<Dentist> dentists = new ArrayList<>();
    try {
      connection = DB.getConnection();
      PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet rs = psSelectAll.executeQuery();
      while (rs.next()) {
        Dentist dentist = new Dentist(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4));
        dentists.add(dentist);
        LOGGER.info("INFO: Odontólogo con id: " + dentist.getId() + ", registro: " + dentist.getRegistration() + ", nombre: " + dentist.getFirstName() + ", apellido: " + dentist.getLastName());
      }
    } catch (Exception e) {
      LOGGER.error("ERROR: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        LOGGER.error("ERROR: " + e.getMessage());
        e.printStackTrace();
      }
    }
    return dentists;
  }
}
