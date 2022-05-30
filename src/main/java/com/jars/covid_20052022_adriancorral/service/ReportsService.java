package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.dto.ReportsDto;
import com.jars.covid_20052022_adriancorral.repository.CountryRepository;
import com.jars.covid_20052022_adriancorral.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public List<ReportsDto> getReports() {
        List<ReportsDto> reports = new ArrayList<>(3);
        reports.add( new ReportsDto("Top 10 countries with highest vaccination", vaccinationRepository.find10CountriesWithHighestVaccination()) );
        reports.add( new ReportsDto("Top 10 countries with lowest vaccination", vaccinationRepository.find10CountriesWithLowestVaccination()) );
        reports.add( new ReportsDto("Top 10 countries with highest infections per 100k inhabitants", countryRepository.find10CountriesWithHighestInfectionsPer100k()) );
        return reports;
    }
}
