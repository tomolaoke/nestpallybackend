package com.example.nestpallybackend;

import com.example.nestpallybackend.controller.HousemateController;
import com.example.nestpallybackend.service.HousemateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(HousemateController.class)
public class HousemateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HousemateService housemateService;

    @Test
    public void testGetAllHousematesEndpoint() throws Exception {
        // Mock the response of the service to return an empty list
        when(housemateService.getAllHousemates()).thenReturn(Collections.emptyList());

        // Perform the GET request and verify the status
        mockMvc.perform(get("/api/housemates"))
                .andExpect(status().isOk());
    }
}

