package com.anyquestions69.site;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
