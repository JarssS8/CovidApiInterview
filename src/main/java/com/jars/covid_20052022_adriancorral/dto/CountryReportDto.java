package com.jars.covid_20052022_adriancorral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryReportDto implements Serializable {
    private String countryName;
    private long value;
}
