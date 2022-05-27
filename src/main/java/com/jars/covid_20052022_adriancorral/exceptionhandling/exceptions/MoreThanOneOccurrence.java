package com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions;

public class MoreThanOneOccurrence extends RuntimeException {

    private static final String MORE_THAN_ONE_COUNTRY_EXCEPTION_MESSAGE = "There are more that one country with the same part of the name.";

    public MoreThanOneOccurrence() {
        super(MORE_THAN_ONE_COUNTRY_EXCEPTION_MESSAGE);
    }

}
