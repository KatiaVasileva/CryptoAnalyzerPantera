package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

import java.io.IOException;

public class Decrypt extends Action{
    @Override
    public void execute(Request request) throws IOException {
        prepareFiles(request.getSourceFile(), request.getTargetFile(), -1 * request.getKey());
    }
}
