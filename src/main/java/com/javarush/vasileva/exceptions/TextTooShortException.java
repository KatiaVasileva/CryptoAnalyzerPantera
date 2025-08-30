package com.javarush.vasileva.exceptions;

public class TextTooShortException extends RuntimeException {

    public TextTooShortException() {
    }

    @Override
    public String getMessage() {
        return "Text too short to be decrypted by brute force";
    }
}
