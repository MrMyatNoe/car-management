package com.truck.car.exception;

import org.springframework.http.ResponseEntity;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return notFoundResponse();
	}
}
