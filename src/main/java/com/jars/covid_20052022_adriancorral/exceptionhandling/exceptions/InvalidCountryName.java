package com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions;

public class InvalidCountryName extends RuntimeException {

    private static final String INVALID_COUNTRY_NAME_EXCEPTION_MESSAGE = "The format of the country name is null or empty";

    public InvalidCountryName() {
        super(INVALID_COUNTRY_NAME_EXCEPTION_MESSAGE);
    }

}
