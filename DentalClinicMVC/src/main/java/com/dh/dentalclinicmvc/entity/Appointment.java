package com.dh.dentalclinicmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "date")
  private LocalDate date;

  @ManyToOne(fetch = FetchType.EAGER)
  private Patient patient;
  @ManyToOne(fetch = FetchType.EAGER)
  private Dentist dentist;
}
