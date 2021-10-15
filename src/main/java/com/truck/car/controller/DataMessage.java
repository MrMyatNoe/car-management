package com.truck.car.controller;

public enum DataMessage {
    
    SUCCESS("Data Found!"), CREATED("Data Created!"), UPDATED("Data Updated!"), DELETED("Data Deleted!");

    private String message;
    
    private DataMessage(final String message) {
        this.message = message;
    }

    protected String getMessage(){
        return message;
    }
}
