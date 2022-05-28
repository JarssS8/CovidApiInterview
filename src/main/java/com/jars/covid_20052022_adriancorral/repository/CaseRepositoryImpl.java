package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.entity.Case;
import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.NotCaseFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class CaseRepositoryImpl implements CaseRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CountryQueryDto findDailyInfectionsAndDeathsPerCountryAndDate(String code, Date date) {
        Case dailyCases;
        CountryQueryDto countryQueryDto;
        try {
            Query query = entityManager.createNativeQuery("SELECT * " +
                    "FROM cases " +
                    "WHERE iso_country = :code " +
                    "and recorded_date = :date", Case.class);
            query.setParameter("code", code);
            query.setParameter("date", date);
            dailyCases = (Case) query.getSingleResult();
            countryQueryDto = new CountryQueryDto(code, dailyCases.getInfections(), dailyCases.getDeaths(),
                    new SimpleDateFormat("yyyy-MM-dd").format(date));
        } catch (NoResultException e) {
            throw new NotCaseFoundException();
        }

        return countryQueryDto;
    }
}
