package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.*;
import com.jars.covid_20052022_adriancorral.repository.CaseRepository;
import com.jars.covid_20052022_adriancorral.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
class InfectionsServiceTests {

    @MockBean
    private CaseRepository caseRepository;

    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private InfectionsService infectionsService;

    @Test
    void getInfectionsOnCountryWithDate_ExpectInvalidCountryNameException() {
        try {
            infectionsService.getInfectionsBasedOnCountryAndDate("", "2020-02-22");
            fail("Should have thrown an country name exception");
        } catch (InvalidCountryName e) {
            assertEquals(InvalidCountryName.INVALID_COUNTRY_NAME_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    void getInfectionsOnCountryWithDate_ExpectInvalidDateFormatException() {
        try {
            infectionsService.getInfectionsBasedOnCountryAndDate("Swe", "asd");
            fail("Should have thrown an date format exception");
        } catch (InvalidDateFormat e) {
            assertEquals(InvalidDateFormat.INVALID_DATE_FORMAT_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    void getInfectionsOnCountryWithDate_ExpectNotCountryFound() {
        try {
            willThrow(new NotCountryFoundException()).given(countryRepository).findCountryCodeByPartialName("Villasante");
            infectionsService.getInfectionsBasedOnCountryAndDate("Villasante", "2022-02-22");
            fail("Should have thrown an not country found exception");
        } catch (NotCountryFoundException e) {
            assertEquals(NotCountryFoundException.NOT_COUNTRY_FOUND_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    void getInfectionsOnCountryWithDate_ExpectMoreThanOneOccurrence() {
        try {
            willThrow(new MoreThanOneOccurrence()).given(countryRepository).findCountryCodeByPartialName("a");
            infectionsService.getInfectionsBasedOnCountryAndDate("a", "2022-02-22");
            fail("Should have thrown an more than one occurrence exception");
        } catch (MoreThanOneOccurrence e) {
            assertEquals(MoreThanOneOccurrence.MORE_THAN_ONE_COUNTRY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    void getInfectionsOnCountryWithDate_ExpectCountryQueryDto() {
        // Create a country query dto
        CountryQueryDto countryQueryDtoMock = new CountryQueryDto("Sweden", 200, 50, "2020-02-22");
        when(countryRepository.findCountryCodeByPartialName("Sweden")).thenReturn("SWE");
        when(caseRepository.findDailyInfectionsAndDeathsPerCountryAndDate("SWE",
                Date.valueOf(countryQueryDtoMock.getDate())))
                .thenReturn(countryQueryDtoMock);
        CountryQueryDto resultCountryQuery = infectionsService.getInfectionsBasedOnCountryAndDate("Sweden",
                "2020-02-22");

        assertEquals(countryQueryDtoMock.getCountry(), resultCountryQuery.getCountry());
        assertEquals(countryQueryDtoMock.getInfected(), resultCountryQuery.getInfected());
        assertEquals(countryQueryDtoMock.getDeaths(), resultCountryQuery.getDeaths());
        assertEquals(countryQueryDtoMock.getDate(), resultCountryQuery.getDate());
    }
}
