package com.jars.covid_20052022_adriancorral.service;

import com.jars.covid_20052022_adriancorral.repository.VaccinationRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ReportsService {
    @MockBean
    private VaccinationRepository vaccinationRepository;

}
