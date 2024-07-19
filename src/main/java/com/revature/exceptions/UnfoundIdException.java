package com.revature.exceptions;

public class UnfoundIdException extends Exception{

    public UnfoundIdException(String message){
        super(message);
    }
    public UnfoundIdException(String message, Throwable cause){
        super(message, cause);
    }
}
