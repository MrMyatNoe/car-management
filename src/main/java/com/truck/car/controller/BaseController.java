package com.truck.car.controller;

import com.truck.car.response.DefaultResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class BaseController {    

    protected ResponseEntity<Object> createResponse(Object object){
        System.out.println("create response");
        DefaultResponse res = new DefaultResponse();
        DataMessage create = DataMessage.CREATED;
        res.setMessage(create.getMessage());
        res.setCode(HttpStatus.CREATED.value());
        res.setData(object);
        return new ResponseEntity<Object>(res,HttpStatus.CREATED);
    }
    
    protected ResponseEntity<Object> successResponse(Object object){
        System.out.println("get response");
        DefaultResponse res = new DefaultResponse();
        DataMessage success = DataMessage.SUCCESS;
        res.setMessage(success.getMessage());
        res.setCode(HttpStatus.OK.value());
        res.setData(object);
        return new ResponseEntity<Object>(res,HttpStatus.OK);
    }

    protected ResponseEntity<Object> updateResponse(Object object){
        System.out.println("update response");
        DefaultResponse res = new DefaultResponse();
        DataMessage update = DataMessage.UPDATED;
        res.setMessage(update.getMessage());
        res.setCode(HttpStatus.OK.value());
        res.setData(object);
        return new ResponseEntity<Object>(res,HttpStatus.OK);
    }

    protected ResponseEntity<Object> deleteResponse(Object object){
        System.out.println("delete response");
        DefaultResponse res = new DefaultResponse();
        DataMessage delete = DataMessage.DELETED;
        res.setMessage(delete.getMessage());
        res.setCode(HttpStatus.OK.value());
        res.setData(object);
        return new ResponseEntity<Object>(res,HttpStatus.OK);
    }

    protected ResponseEntity<Object> badRequestResponse(Object object){
        System.out.println("bad request");
        DefaultResponse res = new DefaultResponse();
        res.setMessage("hello");
        res.setData(object);
        res.setCode(HttpStatus.OK.value());
        res.setStatus("Good");
        return new ResponseEntity<Object>(res,HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> notFoundResponse(Object object){
        System.out.println("not found");
        DefaultResponse res = new DefaultResponse();
        res.setMessage("hello");
        res.setData(object);
        res.setCode(HttpStatus.OK.value());
        res.setStatus("Good");
        return new ResponseEntity<Object>(res,HttpStatus.NOT_FOUND);
    }

    protected void logInfo(String message){
        System.out.println(message);
    }

    protected void logError(Throwable t, String message){
        t.printStackTrace();
        System.out.println(message);
    }
}
