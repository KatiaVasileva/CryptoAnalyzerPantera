package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

public class Decrypt extends Action{
    @Override
    public void execute(Request request) {
        prepareFiles(request.getSourceFile(), request.getTargetFile(), -1 * request.getKey());
    }
}
