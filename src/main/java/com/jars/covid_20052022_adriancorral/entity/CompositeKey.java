package com.jars.covid_20052022_adriancorral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompositeKey implements Serializable {
    private java.sql.Date recordedDate;
    private String isoCountry;
}
