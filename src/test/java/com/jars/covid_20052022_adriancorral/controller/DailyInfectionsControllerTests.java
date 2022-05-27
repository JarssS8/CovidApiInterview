package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.service.InfectionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DailyInfectionsController.class)
public class DailyInfectionsControllerTests {

    @Autowired
    MockMvc mockMvc;

    private final String API_PATH = "/api/dailyinfections";

    @MockBean
    private InfectionsService superHeroService;

    @Test
    void getDailyInfections_ExpectCode200_ResponseOk() throws Exception {
        mockMvc.perform(get(API_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}
