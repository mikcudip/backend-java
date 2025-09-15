package com.clinicaodontologicaspring;

import com.clinicaodontologicaspring.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaSpringApplication {
  public static void main(String[] args) {
    DB.createTables();
    SpringApplication.run(ClinicaOdontologicaSpringApplication.class, args);
  }

}
