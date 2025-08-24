package com.javarush.vasileva.service;

public class Encrypt extends Action{
    @Override
    public void execute(String src, String dest, int key) {
        super.prepareFiles(src, dest, key);
    }
}
