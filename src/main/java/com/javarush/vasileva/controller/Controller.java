package com.javarush.vasileva.controller;

import com.javarush.vasileva.service.Action;
import com.javarush.vasileva.service.Decrypt;
import com.javarush.vasileva.service.Encrypt;

import java.util.HashMap;

public class Controller {
    public void doAction(String src, String dest, int key, int choice) {
        HashMap<Integer, Action> actions = new HashMap<>();
        actions.put(1, new Encrypt());
        actions.put(2, new Decrypt());

        switch (choice) {
            case 1 -> actions.get(1).execute(src, dest, key);
            case 2 -> actions.get(2).execute(src, dest, key);
            default -> System.out.println("Invalid choice");
        }
    }
}
