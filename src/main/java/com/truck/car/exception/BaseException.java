package com.truck.car.exception;

import com.truck.car.response.DefaultResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseException extends RuntimeException{
    
    public BaseException(String message) {
		super(message);
	}
	
	protected ResponseEntity<Object> badRequestResponse(){
		DefaultResponse resp = new DefaultResponse();
		resp.setMessage(getMessage());
        resp.setCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Object>(resp,HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> notFoundResponse(){
		DefaultResponse resp = new DefaultResponse();
		resp.setMessage(getMessage());
		resp.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Object>(resp,HttpStatus.NOT_FOUND);
	}

    protected ResponseEntity<Object> alreadyExistResponse(){
		DefaultResponse resp = new DefaultResponse();
		resp.setMessage(getMessage());
		resp.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<Object>(resp,HttpStatus.FOUND);
	}
	
	public abstract ResponseEntity<Object> response();
}
