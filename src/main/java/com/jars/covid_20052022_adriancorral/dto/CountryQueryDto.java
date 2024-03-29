package com.jars.covid_20052022_adriancorral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryQueryDto implements Serializable {

    private String country;
    private long infected;
    private long deaths;
    private String date;

}
