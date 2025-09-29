package com.dh.dentalclinicmvc.model;

public class Address {
  private Long id;
  private String street;
  private Integer number;
  private String location;
  private String province;

  public Address() {
  }

  public Address(Long id, String street, Integer number, String location, String province) {
    this.id = id;
    this.street = street;
    this.number = number;
    this.location = location;
    this.province = province;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
}
