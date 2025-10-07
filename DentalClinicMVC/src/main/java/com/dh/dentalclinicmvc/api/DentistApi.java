package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.entity.Dentist;
import com.dh.dentalclinicmvc.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistApi {
  private final IDentistService dentistService;

  @Autowired
  public DentistApi(IDentistService dentistService) {
    this.dentistService = dentistService;
  }

  @PostMapping
  public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
    return ResponseEntity.ok(dentistService.save(dentist));
  }

  @PutMapping
  public ResponseEntity<String> update(@RequestBody Dentist dentist) {
    if (!dentistService.update(dentist)) {
      return ResponseEntity.ok("No se puede actualizar un odontólogo que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se actualizó el odontólogo.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (!dentistService.deleteById(id)) {
      return ResponseEntity.ok("No se puede eliminar un odontólogo que no existe en la base de datos.");
    }
    return ResponseEntity.ok("Se eliminó el odontólogo.");
  }

  @GetMapping("/{id}")
  public ResponseEntity<Dentist> findById(@PathVariable Long id) {
    Dentist dentist = dentistService.findById(id);
    if (dentist == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dentist);
  }

  @GetMapping
  public ResponseEntity<List<Dentist>> findAll() {
    return ResponseEntity.ok(dentistService.findAll());
  }

  @GetMapping("/registration/{registration}")
  public ResponseEntity<Dentist> findByRegistration(@PathVariable Long registration) {
    Dentist dentist = dentistService.findByRegistration(registration);
    if (dentist == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dentist);
  }
}
