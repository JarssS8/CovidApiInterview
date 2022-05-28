package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;

import java.util.Date;

public interface CaseRepository {

    CountryQueryDto findDailyInfectionsAndDeathsPerCountryAndDate(String code, Date date);
}
