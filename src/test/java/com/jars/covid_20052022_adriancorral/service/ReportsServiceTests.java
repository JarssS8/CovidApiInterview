package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;
import com.jars.covid_20052022_adriancorral.dto.ReportsDto;
import com.jars.covid_20052022_adriancorral.repository.CountryRepository;
import com.jars.covid_20052022_adriancorral.repository.VaccinationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReportsServiceTests {
    @MockBean
    private VaccinationRepository vaccinationRepository;

    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private ReportsService reportsService;

    private static List<CountryReportDto> countryReportHigherDtoList;
    private static List<CountryReportDto> countryReportLowerDtoList;
    private static List<CountryReportDto> countryReportHigherVaccinationDtoList;

    @BeforeAll
    static void setUp() {

        // Set up collections of CountryReportDto
        countryReportHigherDtoList = new ArrayList<>(3);
        countryReportHigherDtoList.add(new CountryReportDto("Spain", 500));
        countryReportHigherDtoList.add(new CountryReportDto("Germany", 300));
        countryReportHigherDtoList.add(new CountryReportDto("France", 200));
        // Sort to ensure higher values is first
        countryReportHigherDtoList.sort((o1, o2) -> Long.compare(o2.getValue(), o1.getValue()));

        // Set up collection for lower values
        countryReportLowerDtoList = new ArrayList<>(countryReportHigherDtoList);
        // After sort reverse to have another list with lower values
        Collections.reverse(countryReportLowerDtoList);

    }

    @Test
    void getReports_ExpectListCountryReportsDto() {
        // Mock the repository
        when(vaccinationRepository.find10CountriesWithHighestVaccination()).thenReturn(countryReportHigherDtoList);

        // Mock the repository
        when(vaccinationRepository.find10CountriesWithLowestVaccination()).thenReturn(countryReportLowerDtoList);

        // Set up collection for highest infections values
        when(countryRepository.find10CountriesWithHighestInfectionsPer100k()).thenReturn(countryReportHigherDtoList);

        // Get the reports from the service
        List<ReportsDto> reports = reportsService.getReports();

        // Check if the list is not null
        assertNotNull(reports);

        // Check if the list has 3 elements
        assertEquals(3, reports.size());

        // Check if the first element is the one with the highest values
        CountryReportDto higherCountry = countryReportHigherDtoList.get(0);
        assertEquals("Top 10 countries with highest vaccination", reports.get(0).getReportName());
        assertEquals(reports.get(0).getCountries().get(0).getCountryName(), higherCountry.getCountryName());
        assertEquals(reports.get(0).getCountries().get(0).getValue(), higherCountry.getValue());

        // Check if the second element is the one with the lowest values
        CountryReportDto lowerCountry = countryReportLowerDtoList.get(0);
        assertEquals("Top 10 countries with lowest vaccination", reports.get(1).getReportName());
        assertEquals(reports.get(1).getCountries().get(0).getCountryName(), lowerCountry.getCountryName());
        assertEquals(reports.get(1).getCountries().get(0).getValue(), lowerCountry.getValue());

        // Check if the third element is the one with the highest values
        CountryReportDto higherInfections = countryReportHigherDtoList.get(0);
        assertEquals("Top 10 countries with highest infections per 100k inhabitants", reports.get(2).getReportName());
        assertEquals(reports.get(2).getCountries().get(0).getCountryName(), higherInfections.getCountryName());
        assertEquals(reports.get(2).getCountries().get(0).getValue(), higherInfections.getValue());
    }

}
