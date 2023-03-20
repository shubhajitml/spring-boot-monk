package com.learn.springbootdemo.model;

public class ErrorMessage {
//    private HttpStatus status;
//    private int statusCode;

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
