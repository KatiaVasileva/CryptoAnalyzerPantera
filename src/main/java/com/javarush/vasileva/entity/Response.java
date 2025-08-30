package com.javarush.vasileva.entity;

public record Response(String code, ResponseType type, String message) {
}
