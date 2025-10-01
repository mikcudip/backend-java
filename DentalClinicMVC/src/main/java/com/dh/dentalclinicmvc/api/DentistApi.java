package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.model.Dentist;
import com.dh.dentalclinicmvc.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistApi implements BaseApi<Dentist, Long> {
  DentistService dentistService;

  @Autowired
  public DentistApi(DentistService patientService) {
    this.dentistService = patientService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
    return ResponseEntity.ok(dentistService.save(dentist));
  }

  @Override
  @PutMapping
  public void update(@RequestBody Dentist dentist) {
    dentistService.update(dentist);
  }

  @Override
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    dentistService.delete(id);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Dentist> findById(@PathVariable Long id) {
    return ResponseEntity.ok(dentistService.findById(id));
  }

  @Override
  @GetMapping
  public ResponseEntity<List<Dentist>> findAll() {
    return ResponseEntity.ok(dentistService.findAll());
  }
}
