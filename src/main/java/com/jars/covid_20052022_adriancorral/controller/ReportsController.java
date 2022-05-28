package com.jars.covid_20052022_adriancorral.controller;

import com.jars.covid_20052022_adriancorral.dto.ReportsDto;
import com.jars.covid_20052022_adriancorral.service.ReportsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@Controller
@Api(value = "Reports about COVID-19")
public class ReportsController {

    @Autowired
    ReportsService reportsService;

    @GetMapping
    @ApiOperation(value = "Get reports about COVID-19, for highest and lower infections vaccination, and for highest " +
            "infections per 100k inhabitants")
    public ResponseEntity<List<ReportsDto>> getReports() {
        return ResponseEntity.ok(reportsService.getReports());
    }
}
