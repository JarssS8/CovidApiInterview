package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository {
    List<CountryReportDto> find10CountriesWithHighestVaccination();
    List<CountryReportDto> find10CountriesWithLowestVaccination();
}
