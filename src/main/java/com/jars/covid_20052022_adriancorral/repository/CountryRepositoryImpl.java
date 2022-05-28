package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;
import com.jars.covid_20052022_adriancorral.entity.Country;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.MoreThanOneOccurrence;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.NotCountryFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String findCountryCodeByPartialName(String name) {
        Country country;
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM countries " +
                    "WHERE LOWER(countries.name) LIKE :name", Country.class);
            query.setParameter("name", "%" + name + "%");
            country = (Country) query.getSingleResult();

        } catch (NonUniqueResultException e) {
            throw new MoreThanOneOccurrence();
        } catch (NoResultException e) {
            throw new NotCountryFoundException();
        }

        return country.getCode();
    }

    @Override
    public List<CountryReportDto> find10CountriesWithHighestInfectionsPer100k() {
        Query query = entityManager.createNativeQuery("SELECT countries.name AS countryName, " +
                "(SUM(infections)*100000)/population AS infectionsPer100k " +
                "FROM countries " +
                "JOIN cases c ON countries.code = c.iso_country " +
                "GROUP BY countryName, population " +
                "ORDER BY infectionsPer100k DESC " +
                "LIMIT 10;");
        return query.getResultList();
    }
}
