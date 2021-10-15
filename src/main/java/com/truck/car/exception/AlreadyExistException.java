package com.truck.car.exception;

import org.springframework.http.ResponseEntity;

public class AlreadyExistException extends BaseException{
    
    public AlreadyExistException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return notFoundResponse();
	}
}
