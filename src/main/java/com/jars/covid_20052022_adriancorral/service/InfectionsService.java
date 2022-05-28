package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.InvalidCountryName;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.InvalidDateFormat;
import com.jars.covid_20052022_adriancorral.repository.CaseRepository;
import com.jars.covid_20052022_adriancorral.repository.CountryRepository;
import com.jars.covid_20052022_adriancorral.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class InfectionsService {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private CountryRepository countryRepository;

    public CountryQueryDto getInfectionsBasedOnCountryAndDate(String countryName, String dateStr) {
        if (countryName == null || countryName.isEmpty())
            throw new InvalidCountryName();
        Date date = convertDateFollowingPattern(dateStr);
        String isoCountry = countryRepository.findCountryCodeByPartialName(countryName);

        return caseRepository.findDailyInfectionsAndDeathsPerCountryAndDate(isoCountry, date);
    }

    private Date convertDateFollowingPattern(String dateStr) {
        try {
            Pattern pattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
            if (!pattern.matcher(dateStr).matches())
                throw new ParseException("Invalid date format", 0);
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new InvalidDateFormat();
        }
    }

}
