package com.dh.clinicaodontologicaii.controller;

import com.dh.clinicaodontologicaii.entities.Dentist;
import com.dh.clinicaodontologicaii.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
  private final DentistService dentistService;

  @Autowired
  public DentistController(DentistService dentistService) {
    this.dentistService = dentistService;
  }

  @PostMapping("/save")
  public Dentist save(@RequestBody Dentist dentist) {
    return dentistService.save(dentist);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Dentist> findById(@PathVariable Long id) {
    if (dentistService.findById(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(dentistService.findById(id));
  }


  @PutMapping("/{id}")
  public Dentist update(@RequestBody Dentist dentist) {
    if (!dentistService.existsById(dentist.getId())) {
      return null;
    }
    dentistService.update(dentist);
    return dentist;
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    if (!dentistService.existsById(id)) {
      return "No se encontró el odontólogo con id: " + id;
    }
    dentistService.delete(id);
    return "Se eliminó correctamente el odontólogo con id: " + id;
  }

  @GetMapping("/all")
  public List<Dentist> findAll() {
    return dentistService.findAll();
  }
}
