package com.dh.dentalclinicmvc.controller;

import com.dh.dentalclinicmvc.model.Patient;
import com.dh.dentalclinicmvc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
  private PatientService patientService;

  @Autowired
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping("")
  public String findPatientByEmail(Model model, @RequestParam String email) {
    Patient patient = patientService.findByEmail(email);
    model.addAttribute("firstName", patient.getFirstName());
    model.addAttribute("lastName", patient.getLastName());
    return "index";
  }

  @ResponseBody
  @PostMapping("/save")
  public Patient save(@RequestBody Patient patient) {
    return patientService.save(patient);
  }
}
