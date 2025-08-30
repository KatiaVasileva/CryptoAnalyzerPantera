package com.javarush.vasileva.controller;

import com.javarush.vasileva.entity.Request;
import com.javarush.vasileva.service.Action;
import com.javarush.vasileva.service.Decrypt;
import com.javarush.vasileva.service.Encrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Controller {
    public void doAction(Request request, int choice) {
        HashMap<Integer, Action> actions = new HashMap<>();
        actions.put(1, new Encrypt());
        actions.put(2, new Decrypt());

        try {
            switch (choice) {
                case 1 -> actions.get(1).execute(request);
                case 2 -> actions.get(2).execute(request);
                default -> System.out.println("Invalid choice");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
