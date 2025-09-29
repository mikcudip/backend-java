package com.dh.dentalclinicmvc.dao;

import com.dh.dentalclinicmvc.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOH2 implements IDAO<Address> {
  public static final String SQL_INSERT_ADDRESSES = "INSERT INTO addresses (street,number,location,province) VALUES (?,?,?,?)";
  public static final String SQL_SELECT_ADDRESS_ID = "SELECT * FROM addresses WHERE id = ?";
  public static final String SQL_UPDATE_ADDRESS_ID = "UPDATE addresses SET street=?, number=?, location=?, province=? WHERE id=?;";
  public static final String SQL_SELECT_ADDRESSES = "SELECT * FROM addresses";

  @Override
  public Address save(Address address) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ADDRESSES, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, address.getStreet());
      preparedStatement.setInt(2, address.getNumber());
      preparedStatement.setString(3, address.getLocation());
      preparedStatement.setString(4, address.getProvince());
      preparedStatement.executeUpdate();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()) {
        address.setId(resultSet.getLong(1));
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
    return address;
  }

  @Override
  public Address findById(Long id) {
    Connection connection = null;
    Address address = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ADDRESS_ID);
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        address = new Address(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
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
    return address;
  }

  @Override
  public void update(Address address) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS_ID);
      preparedStatement.setString(1, address.getStreet());
      preparedStatement.setInt(2, address.getNumber());
      preparedStatement.setString(3, address.getLocation());
      preparedStatement.setString(4, address.getProvince());
      preparedStatement.setLong(5, address.getId());
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
  public void delete(Long id) {
    Connection connection = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM addresses WHERE id = ?");
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
  public List<Address> findAll() {
    Connection connection = null;
    List<Address> addresses = new ArrayList<>();
    Address address = null;
    try {
      connection = DB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ADDRESSES);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        address = new Address(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
        addresses.add(address);
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
    return addresses;
  }

  @Override
  public Address findByString(String value) {
    return null;
  }
}
