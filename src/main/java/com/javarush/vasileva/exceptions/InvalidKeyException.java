package com.javarush.vasileva.exceptions;

public class InvalidKeyException extends RuntimeException {
    public InvalidKeyException() {
    }

    public String getMessage() {
        return "Invalid key";
    }
}
