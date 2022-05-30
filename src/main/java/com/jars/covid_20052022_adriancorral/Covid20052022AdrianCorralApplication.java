package com.jars.covid_20052022_adriancorral;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Covid20052022AdrianCorralApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid20052022AdrianCorralApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
