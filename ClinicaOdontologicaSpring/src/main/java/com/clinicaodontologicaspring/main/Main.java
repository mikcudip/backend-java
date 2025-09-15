package com.clinicaodontologicaspring.main;

import com.clinicaodontologicaspring.dao.DB;
import com.clinicaodontologicaspring.dao.impl.DentistDAOH2;
import com.clinicaodontologicaspring.model.Dentist;
import com.clinicaodontologicaspring.service.DentistService;

public class Main {
  public static void main(String[] args) {
    DentistService dentistService = new DentistService(new DentistDAOH2());

    DB.createTables();

    Dentist dentist1 = new Dentist(132L, "Vanina", "Godoy");
    Dentist dentist2 = new Dentist(456L, "Mik", "Cudi");
    Dentist dentist3 = new Dentist(789L, "Paolin", "Lin Lin");

    dentistService.save(dentist2);
    dentistService.save(dentist1);
    dentistService.save(dentist3);

    Long idFind = 2L;
    dentistService.findById(idFind);

    String updatedName = "Mik Cudi";
    dentist1.setFirstName(updatedName);
    dentistService.update(dentist1);

    System.out.println("El nombre actualizado es: " + dentist1.getFirstName());

    Long idDelete = 2L;
    dentistService.delete(idDelete);

    dentistService.findAll();
  }
}
