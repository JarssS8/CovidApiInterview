package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;

import java.util.List;

public interface CountryRepository{
    String findCountryCodeByPartialName(String name);
    List<CountryReportDto> find10CountriesWithHighestInfectionsPer100k();
}
