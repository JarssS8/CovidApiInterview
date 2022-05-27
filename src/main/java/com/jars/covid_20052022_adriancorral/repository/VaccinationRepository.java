package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.entity.Case;
import com.jars.covid_20052022_adriancorral.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}
