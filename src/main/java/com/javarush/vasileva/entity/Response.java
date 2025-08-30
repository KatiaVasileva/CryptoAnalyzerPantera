package com.javarush.vasileva.entity;

public class Response {
    private final String code;
    private final ResponseType type;
    private final String message;

    public Response(String code, ResponseType type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public ResponseType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
