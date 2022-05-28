package com.jars.covid_20052022_adriancorral.exceptionhandling;

import com.jars.covid_20052022_adriancorral.exceptionhandling.exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MoreThanOneOccurrence.class)
    public ResponseEntity<Object> handleGeneralException(MoreThanOneOccurrence e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("Multiple Choices", "300",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NotCountryFoundException.class)
    public ResponseEntity<Object> handleGeneralException(NotCountryFoundException e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("No Country Found", "404",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NotCaseFoundException.class)
    public ResponseEntity<Object> handleGeneralException(NotCaseFoundException e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("No Case Found", "404",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(InvalidDateFormat.class)
    public ResponseEntity<Object> handleGeneralException(InvalidDateFormat e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("Invalid Date Format", "403",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(InvalidCountryName.class)
    public ResponseEntity<Object> handleGeneralException(InvalidCountryName e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("Invalid Country Name", "403",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.NOT_FOUND, request);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleGeneralException(RuntimeException e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<ErrorItem> errorItems = Stream.of(new ErrorItem("Runtime Exception", "GL000",
                e.getMessage())).collect(Collectors.toList());
        return handleExceptionInternal(e, errorItems, headers, HttpStatus.BAD_REQUEST, request);
    }

}
