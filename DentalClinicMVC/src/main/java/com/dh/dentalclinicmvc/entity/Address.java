package com.dh.dentalclinicmvc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "street")
  private String street;
  @Column(name = "number")
  private Integer number;
  @Column(name = "location")
  private String location;
  @Column(name = "province")
  private String province;

  @OneToOne(mappedBy = "address")
  private Patient patient;

  public Address() {
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
