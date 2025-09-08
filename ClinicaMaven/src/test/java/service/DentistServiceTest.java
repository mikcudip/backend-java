package service;

import dao.DB;
import dao.impl.DentistDAOH2;
import model.Dentist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DentistServiceTest {
  DentistService dentistService = new DentistService(new DentistDAOH2());

  @Test
  void save() {
    DB.createTables();
    Dentist dentist = new Dentist();
    dentist.setRegistration(555L);
    dentist.setFirstName("Carolina");
    dentist.setLastName("Garro");

    dentistService.save(dentist);

    Assertions.assertNotNull(dentist.getId());
  }

  @Test
  void update() {
    Dentist dentist = new Dentist();
    dentist.setId(1L);
    dentist.setRegistration(12345L);
    dentist.setFirstName("Juan Andrés");
    dentist.setLastName("Pérez");
    dentistService.update(dentist);
    Assertions.assertNotNull(dentist.getId());
    Assertions.assertEquals("Juan Andrés", dentist.getFirstName());
  }

  @Test
  void delete() {
    Dentist dentistDeleted = dentistService.findById(2L);
    Assertions.assertNull(dentistDeleted);
  }

  @Test
  void findById() {
    Assertions.assertNotNull(dentistService.findById(1L));
  }

  @Test
  void findAll() {
    List<Dentist> dentists = dentistService.findAll();
    Assertions.assertFalse(dentists.isEmpty());
  }
}
