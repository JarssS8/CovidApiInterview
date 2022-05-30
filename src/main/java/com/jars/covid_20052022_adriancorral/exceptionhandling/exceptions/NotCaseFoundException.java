package com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions;

public class NotCaseFoundException extends RuntimeException {

    public static final String NOT_CASE_FOUND_EXCEPTION_MESSAGE = "There are not a case with that parameters.";

    public NotCaseFoundException() {
        super(NOT_CASE_FOUND_EXCEPTION_MESSAGE);
    }

}
