package com.example.restdemo.controllerTest;
import com.example.restdemo.model.Doctor;
import com.example.restdemo.repository.DoctorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Setting up the expected list of Person objects which the controller should return.
    List<Doctor> expectedDoctor = List.of(
            new Doctor(1L, "Jane", 45454464L,"jane@gmail.com","123 Main St","Oncology"),
            new Doctor(2L,"Mark",55578544L,"mark@gmail.com","456 Main St","Chemo"),
            new Doctor(3L,"Sam",454545454L,"sam@gmail.com","798 Main St","ICU"));

    @Autowired
    private DoctorRepository doctorRepository;

    @BeforeEach
    public void setup() {}

    @Test
    public void testGetAllPeople() throws Exception {
        // Save the objects to DB
        doctorRepository.saveAll(expectedDoctor);

        // Converting the expected list of people to a JSON string.
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedDoctor);

        // Using mockMvc to perform an HTTP GET request to /people
        mockMvc.perform(get("/doctor"))
                // Expecting the HTTP status to be 200 OK
                .andExpect(status().isOk())
                // Expecting the response body to be the JSON representation of the expected list of people.
                .andExpect(content().json(expectedJsonResponse));
    }
}
