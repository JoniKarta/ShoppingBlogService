package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadFilterTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadFilterTypeException() {
	}

	public BadFilterTypeException(String message) {
		super(message);
	}
}
