package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

import java.io.IOException;

public class Encrypt extends Action{
    @Override
    public void execute(Request request) throws IOException {
        super.prepareFiles(request.getSourceFile(), request.getTargetFile(), request.getKey());
    }
}
