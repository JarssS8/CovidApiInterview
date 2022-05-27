package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.entity.Case;
import com.jars.covid_20052022_adriancorral.entity.Country;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.MoreThanOneOccurrence;
import com.jars.covid_20052022_adriancorral.repository.CaseRepository;
import com.jars.covid_20052022_adriancorral.repository.CountryRepository;
import com.jars.covid_20052022_adriancorral.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class InfectionsService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public Country getInfectionsBasedOnCountryAndDate(String countryName, String date) {
        String isoCountry = countryRepository.findCountryCodeByPartialName(countryName);
        Case caseByCountryAndDate = caseRepository.findCaseByIsoCodeAndDate(isoCountry, date);

        return new Country();
    }

}
