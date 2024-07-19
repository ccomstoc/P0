package com.revature.exceptions;

public class AlbumAlreadyExistsException extends Exception{

    public AlbumAlreadyExistsException(String message){
        super(message);
    }

    public AlbumAlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }

}
