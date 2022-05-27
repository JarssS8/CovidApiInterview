package com.jars.covid_20052022_adriancorral.repository;

import com.jars.covid_20052022_adriancorral.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CaseRepository extends JpaRepository<Case, Long> {

    @Query("SELECT c FROM cases c WHERE c.iso_country= :code AND c.date = :date")
    Case findCaseByIsoCodeAndDate(@Param("code") String isoCountry, @Param("date") String date);
}
