package com.javarush.vasileva.entity;

public enum ResponseType {
    OK("200"),
    BAD_REQUEST("400"),
    NOT_FOUND("404"),
    ERROR("404");

    private final String code;

    ResponseType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
