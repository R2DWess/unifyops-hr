package com.corp.unifyops.hr.employee;

import com.corp.unifyops.hr.employee.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private String employeeJson;

    @BeforeEach
    public void setup() throws Exception {
        // Limpa o banco de dados antes de cada teste
        employeeRepository.deleteAll();

        // Lê o JSON de teste do arquivo
        employeeJson = new String(Files.readAllBytes(
                Paths.get("src/test/resources/employee_validation.json")
        ));
    }

    @Test
    public void testRegisterEmployee() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk()) // Valida o status HTTP retornado
                .andExpect(jsonPath("$.employeeId").value("150336725"))
                .andExpect(jsonPath("$.employeeName").value("Emily"))
                .andExpect(jsonPath("$.employeeEmail").value("emily@email.com"))
                .andExpect(jsonPath("$.employeePhone").value("(61) 9 9449-0383"))
                .andExpect(jsonPath("$.employeeAge").value("22"))
                .andExpect(jsonPath("$.employeeAddress.street").value("Alaides"))
                .andExpect(jsonPath("$.employeeAddress.number").value("15"))
                .andExpect(jsonPath("$.employeeAddress.additionalAddressDetails").isEmpty())
                .andExpect(jsonPath("$.employeeAddress.neighborhood").value("Vila Raio de Luz"))
                .andExpect(jsonPath("$.employeeAddress.city").value("Santo Antonio do Descoberto"))
                .andExpect(jsonPath("$.employeeAddress.state").value("GO"))
                .andExpect(jsonPath("$.employeeAddress.postalCode").value("72904268"));
    }
}
