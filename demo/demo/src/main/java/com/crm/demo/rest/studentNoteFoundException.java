package com.crm.demo.rest;

public class studentNoteFoundException extends RuntimeException{
    public studentNoteFoundException(String message) {
        super(message);
    }

    public studentNoteFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public studentNoteFoundException(Throwable cause) {
        super(cause);
    }
}
