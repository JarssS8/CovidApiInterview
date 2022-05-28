package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.service.InfectionsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/infections")
@Controller
@Api(value = "Infections about COVID-19 based on country and date")
public class InfectionsController {

    @Autowired
    InfectionsService infectionsService;

    @GetMapping("/{countryName}/{date}")
    @ApiOperation(value = "Get infections based on country and date")
    @ApiResponses(value = {
            @ApiResponse(code = 300, message = "More than one country found"),
            @ApiResponse(code = 403, message = "Invalid country name/date format"),
            @ApiResponse(code = 404, message = "Not country/case found"),
    })
    public ResponseEntity<CountryQueryDto> getInfectionsBasedOnCountryAndDate(
            @ApiParam(value = "Name or part of the name from a country", required = true)
            @PathVariable("countryName") String countryName,
            @ApiParam(value = "Date of the infections with yyyy-MM-dd format", required = true)
            @PathVariable("date") String date) {
        return ResponseEntity.ok(infectionsService.getInfectionsBasedOnCountryAndDate(countryName, date));
    }
}
