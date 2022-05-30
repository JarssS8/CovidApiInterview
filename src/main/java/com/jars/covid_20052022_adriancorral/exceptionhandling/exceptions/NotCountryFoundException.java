package com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions;

public class NotCountryFoundException extends RuntimeException {

    public static final String NOT_COUNTRY_FOUND_EXCEPTION_MESSAGE = "There are not country with that name.";

    public NotCountryFoundException() {
        super(NOT_COUNTRY_FOUND_EXCEPTION_MESSAGE);
    }

}
