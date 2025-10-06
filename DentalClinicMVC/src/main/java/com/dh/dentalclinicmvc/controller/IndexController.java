package com.dh.dentalclinicmvc.controller;

import com.dh.dentalclinicmvc.model.Dentist;
import com.dh.dentalclinicmvc.model.Patient;
import com.dh.dentalclinicmvc.service.impl.DentistService;
import com.dh.dentalclinicmvc.service.impl.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class IndexController {
  private final PatientService patientService;
  private final DentistService dentistService;

  public IndexController(PatientService patientService, DentistService dentistService) {
    this.patientService = patientService;
    this.dentistService = dentistService;
  }

  @GetMapping("")
  public String findPatientByEmail(Model model, @RequestParam("email") String email, @RequestParam("id") Long id) {
    Patient patient = patientService.findByEmail(email);
    Dentist dentist = dentistService.findById(id);
    model.addAttribute("firstNamePatient", patient.getFirstName());
    model.addAttribute("lastNamePatient", patient.getLastName());
    model.addAttribute("firstNameDentist", dentist.getFirstName());
    model.addAttribute("lastNameDentist", dentist.getLastName());
    model.addAttribute("registrationDentist", dentist.getRegistration());
    return "home";
  }
}
