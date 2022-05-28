package com.jars.covid_20052022_adriancorral.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportsDto implements Serializable {
    private String reportName;
    private List<CountryReportDto> countries;
}
