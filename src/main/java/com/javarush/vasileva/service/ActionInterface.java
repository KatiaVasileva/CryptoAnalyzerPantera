package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

import java.io.IOException;

public interface ActionInterface {
    void execute(Request request) throws IOException;
}
