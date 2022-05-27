package com.jars.covid_20052022_adriancorral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Covid20052022AdrianCorralApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid20052022AdrianCorralApplication.class, args);
	}

}
