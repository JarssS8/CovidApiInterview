package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.service.InfectionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InfectionsController.class)
public class InfectionsControllerTests {

    @Autowired
    MockMvc mockMvc;

    private final String API_PATH = "/api/infections";

    @MockBean
    private InfectionsService infectionsService;

    @Test
    void getInfections_ExpectCode200_ResponseOk() throws Exception {
        String path = API_PATH + "/Spain/2020-03-01";
        mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }

    @Test
    void getInfections_ExpectCountryQueryDto_ResponseOk() throws Exception {
        String countryName = "Spain";
        String date = "2020-03-01";
        long infected = 10;
        long deaths = 20;
        when(infectionsService.getInfectionsBasedOnCountryAndDate(countryName, date)).thenReturn(
                new CountryQueryDto(countryName, infected, deaths, date));

        String path = API_PATH + "/Spain/2020-03-01";
        mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("country").value(countryName))
                .andExpect(MockMvcResultMatchers.jsonPath("infected").value(infected))
                .andExpect(MockMvcResultMatchers.jsonPath("deaths").value(deaths))
                .andExpect(MockMvcResultMatchers.jsonPath("date").value(date));
    }
}
