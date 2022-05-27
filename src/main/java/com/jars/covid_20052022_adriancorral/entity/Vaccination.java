package com.jars.covid_20052022_adriancorral.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "vaccinations")
@IdClass(CompositeKey.class)
public class Vaccination {
    @Id
    @Column(name = "recorded_date")
    private java.sql.Date recordedDate;

    @Column(name = "daily_vaccinations_raw")
    private Long dailyVaccinationsRaw;

    @Column(name = "daily_vaccinations")
    private Long dailyVaccinations;

    @Id
    @Column(name = "iso_country")
    private String isoCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vaccination that = (Vaccination) o;
        return recordedDate != null && Objects.equals(recordedDate, that.recordedDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
