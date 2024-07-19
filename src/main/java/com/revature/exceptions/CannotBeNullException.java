package com.revature.exceptions;

public class CannotBeNullException extends Exception{

    public CannotBeNullException(String message){
        super(message);
    }

    public CannotBeNullException(String message, Throwable cause){
        super(message, cause);
    }
}
