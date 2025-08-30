package com.javarush.vasileva.service;

import com.javarush.vasileva.entity.Request;

public class Encrypt extends Action{
    @Override
    public void execute(Request request) {
        super.prepareFiles(request.getSourceFile(), request.getTargetFile(), request.getKey());
    }
}
