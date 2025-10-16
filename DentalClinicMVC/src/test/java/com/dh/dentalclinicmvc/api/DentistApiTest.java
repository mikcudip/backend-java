package com.dh.dentalclinicmvc.api;

import com.dh.dentalclinicmvc.entity.Dentist;
import com.dh.dentalclinicmvc.service.IDentistService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistApiTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private IDentistService dentistService;

  /*@BeforeEach*/
  public void dataLoad() {
    Dentist dentist = new Dentist();
    dentist.setFirstName("1DMik");
    dentist.setLastName("1DCudi");
    dentist.setRegistration(5826L);
    dentistService.save(dentist);
  }

  @Test
  @Order(2)
  public void testFindById() throws Exception {
    dataLoad();
    mockMvc.perform(get("/api/dentists/1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName").value("1DMik"))
        .andExpect(jsonPath("$.lastName").value("1DCudi"))
        .andExpect(jsonPath("$.registration").value(5826L));
  }

  @Test
  @Order(3)
  public void testPostDentist() throws Exception {
    String dentistSaved = "{\"firstName\": \"2DMik\", \"lastName\": \"2DCudi\", \"registration\": \"25826\" }";
    mockMvc.perform(post("/api/dentists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(dentistSaved)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName").value("2DMik"))
        .andExpect(jsonPath("$.lastName").value("2DCudi"))
        .andExpect(jsonPath("$.registration").value(25826L));
  }

  @Test
  @Order(1)
  public void testFindAllDentists() throws Exception {
    mockMvc.perform(get("/api/dentists"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("[]"));
  }
}
