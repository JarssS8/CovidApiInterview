package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;
import com.jars.covid_20052022_adriancorral.dto.ReportsDto;
import com.jars.covid_20052022_adriancorral.service.ReportsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportsController.class)
class ReportsControllerTests {

    @Autowired
    MockMvc mockMvc;

    private final String API_PATH = "/api/reports";

    @MockBean
    private ReportsService reportsService;

    @Test
    void getReports_ExpectCode200_ResponseOk() throws Exception {
        mockMvc.perform(get(API_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }

    @Test
    void getReports_ExpectListReportsDto_ResponseOk() throws Exception {
        List<ReportsDto> reportsDtoList = getMockReports();
        when(reportsService.getReports()).thenReturn(reportsDtoList);

        mockMvc.perform(get(API_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reportName").value(reportsDtoList.get(0).getReportName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countries").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].reportName").value(reportsDtoList.get(1).getReportName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countries").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].reportName").value(reportsDtoList.get(2).getReportName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countries").isNotEmpty());
    }

    private List<ReportsDto> getMockReports() {
        List<ReportsDto> reports = new ArrayList<>();
        List<CountryReportDto> countryReportDtos = new ArrayList<>();
        countryReportDtos.add(new CountryReportDto("Spain", 200));
        countryReportDtos.add(new CountryReportDto("Germany", 600));
        countryReportDtos.add(new CountryReportDto("France", 20));
        countryReportDtos.add(new CountryReportDto("Ireland", 800));
        reports.add(new ReportsDto("Top vaccination", countryReportDtos));
        reports.add(new ReportsDto("Low vaccination", countryReportDtos));
        reports.add(new ReportsDto("Top infections per 100k inhabitants", countryReportDtos));
        return reports;
    }
}
