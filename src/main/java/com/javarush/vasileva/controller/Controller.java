package com.javarush.vasileva.controller;

import com.javarush.vasileva.entity.Request;
import com.javarush.vasileva.service.Action;
import com.javarush.vasileva.service.Decrypt;
import com.javarush.vasileva.service.Encrypt;

import java.util.HashMap;

public class Controller {
    public void doAction(Request request, int choice) {
        HashMap<Integer, Action> actions = new HashMap<>();
        actions.put(1, new Encrypt());
        actions.put(2, new Decrypt());

        switch (choice) {
            case 1 -> actions.get(1).execute(request);
            case 2 -> actions.get(2).execute(request);
            default -> System.out.println("Invalid choice");
        }
    }
}
