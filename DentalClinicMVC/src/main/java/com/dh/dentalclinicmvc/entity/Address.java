package com.dh.dentalclinicmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
