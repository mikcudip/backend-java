package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Dentist;
import com.dh.dentalclinicmvc.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistApi implements BaseApi<Dentist, Long> {
  private final IDentistService dentistService;

  @Autowired
  public DentistApi(IDentistService dentistService) {
    this.dentistService = dentistService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
    return ResponseEntity.ok(dentistService.save(dentist));
  }

  @Override
  @PutMapping
  public ResponseEntity<String> update(@RequestBody Dentist dentist) {
    if (!dentistService.update(dentist)) {
      return ResponseEntity.ok("No se puede actualizar un odontólogo que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se actualizó el odontólogo.");
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (!dentistService.deleteById(id)) {
      return ResponseEntity.ok("No se puede eliminar un odontólogo que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se eliminó el odontólogo.");
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Dentist> findById(@PathVariable Long id) {
    Dentist dentist = dentistService.findById(id);
    if (dentist == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dentist);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<Dentist>> findAll() {
    return ResponseEntity.ok(dentistService.findAll());
  }
}
