package com.truck.car.exception;

import org.springframework.http.ResponseEntity;

public class BadRequestException extends BaseException{
	
	public BadRequestException(String msg) {
		super(msg);
	}
	
	public ResponseEntity<Object> response(){
		return badRequestResponse();
	}
}
