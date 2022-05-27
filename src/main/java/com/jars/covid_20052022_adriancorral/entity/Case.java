package com.jars.covid_20052022_adriancorral.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cases")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@IdClass(CompositeKey.class)
public class Case {
    @Id
    @Column(name = "recorded_date")
    private java.sql.Date recordedDate;

    @Column(name = "infections")
    private Long infections;

    @Column(name = "deaths")
    private Long deaths;

    @Id
    @Column(name = "iso_country")
    private String isoCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Case aCase = (Case) o;
        return recordedDate != null && Objects.equals(recordedDate, aCase.recordedDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
