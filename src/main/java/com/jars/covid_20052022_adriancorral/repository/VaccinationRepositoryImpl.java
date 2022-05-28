package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.dto.CountryReportDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VaccinationRepositoryImpl implements VaccinationRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountryReportDto> find10CountriesWithHighestVaccination() {
        Query query = entityManager.createNativeQuery("SELECT c.name, SUM(daily_vaccinations) " +
                "FROM vaccinations " +
                "JOIN countries c on vaccinations.iso_country = c.code " +
                "GROUP BY c.name " +
                "ORDER BY SUM(daily_vaccinations) DESC " +
                "LIMIT 10;");
        return query.getResultList();
    }

    @Override
    public List<CountryReportDto> find10CountriesWithLowestVaccination() {
        Query query = entityManager.createNativeQuery("SELECT c.name, SUM(daily_vaccinations) " +
                "FROM vaccinations " +
                "JOIN countries c on vaccinations.iso_country = c.code " +
                "GROUP BY c.name ORDER BY SUM(daily_vaccinations) ASC " +
                "LIMIT 10;");
        return query.getResultList();
    }
}
