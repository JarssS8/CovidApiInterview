package com.jars.covid_20052022_adriancorral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryQueryDto {

    private String country;
    private int infected;
    private int deaths;
    private String date;

}
