package com.javarush.vasileva.service;

public class Decrypt extends Action{
    @Override
    public void execute(String src, String dest, int key) {
        prepareFiles(src, dest, -1 * key);
    }
}
