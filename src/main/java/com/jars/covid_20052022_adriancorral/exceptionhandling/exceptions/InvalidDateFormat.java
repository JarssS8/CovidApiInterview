package com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions;

public class InvalidDateFormat extends RuntimeException {

    private static final String INVALID_DATE_FORMAT_EXCEPTION_MESSAGE = "The format of the date is invalid, please ensure " +
            "that the date is yyyy-MM-dd (Ex. 2020-04-01) and try again.";

    public InvalidDateFormat() {
        super(INVALID_DATE_FORMAT_EXCEPTION_MESSAGE);
    }

}
