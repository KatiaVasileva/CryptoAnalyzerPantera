package com.javarush.vasileva.exceptions;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
    }

    @Override
    public String getMessage() {
        return "File is empty";
    }
}
