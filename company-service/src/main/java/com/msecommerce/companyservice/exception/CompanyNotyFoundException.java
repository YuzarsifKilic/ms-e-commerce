package com.msecommerce.companyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotyFoundException extends RuntimeException {

    public CompanyNotyFoundException(String message) {
        super(message);
    }
}
