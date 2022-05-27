package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.dto.CountryQueryDto;
import com.jars.covid_20052022_adriancorral.entity.Country;
import com.jars.covid_20052022_adriancorral.service.InfectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/dailyinfections")
@Controller
public class DailyInfectionsController {

    @Autowired
    InfectionsService infectionsService;

    @GetMapping("/{countryName}/{date}")
    public ResponseEntity<Country> getInfectionsBasedOnCountryAndDate(@PathVariable("countryName") String countryName, @PathVariable("date") String date) {
        return ResponseEntity.ok(infectionsService.getInfectionsBasedOnCountryAndDate(countryName, date));
    }
}
