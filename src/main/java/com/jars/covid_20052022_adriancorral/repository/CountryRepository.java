package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

public interface CountryRepository{

    String findCountryCodeByPartialName(String name);
}
