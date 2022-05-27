package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.entity.Country;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.MoreThanOneOccurrence;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.NotCountryFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

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
}
