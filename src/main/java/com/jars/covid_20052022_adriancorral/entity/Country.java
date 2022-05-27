package com.jars.covid_20052022_adriancorral.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "countries")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private Long population;

    @Column(name = "continent")
    private String continent;

    @Column(name = "wikipedia_link")
    private String wikipediaLink;

    @Column(name = "keywords")
    private String keywords;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country countries = (Country) o;
        return id != null && Objects.equals(id, countries.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
