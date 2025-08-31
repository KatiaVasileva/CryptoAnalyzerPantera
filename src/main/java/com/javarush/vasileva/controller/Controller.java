package com.javarush.vasileva.controller;

import com.javarush.vasileva.entity.Request;
import com.javarush.vasileva.entity.Response;
import com.javarush.vasileva.entity.ResponseType;
import com.javarush.vasileva.exceptions.EmptyFileException;
import com.javarush.vasileva.exceptions.InvalidKeyException;
import com.javarush.vasileva.exceptions.TextTooShortException;
import com.javarush.vasileva.service.Action;
import com.javarush.vasileva.service.BruteForce;
import com.javarush.vasileva.service.Decrypt;
import com.javarush.vasileva.service.Encrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Controller {
    public Response doAction(Request request, int choice) {
        HashMap<Integer, Action> actions = new HashMap<>();
        actions.put(1, new Encrypt());
        actions.put(2, new Decrypt());
        actions.put(3, new BruteForce());

        try {
            switch (choice) {
                case 1 -> actions.get(1).execute(request);
                case 2 -> actions.get(2).execute(request);
                case 3 -> actions.get(3).execute(request);
                default -> System.out.println("Invalid choice");
            }
        } catch (EmptyFileException | TextTooShortException | InvalidKeyException e) {
            return new Response(ResponseType.BAD_REQUEST.getCode(), ResponseType.BAD_REQUEST, e.getMessage());
        } catch (FileNotFoundException e) {
            return new Response(ResponseType.NOT_FOUND.getCode(), ResponseType.NOT_FOUND, e.getMessage());
        } catch (IOException e) {
            return new Response(ResponseType.ERROR.getCode(), ResponseType.ERROR, e.getMessage());
        }
        return new Response(ResponseType.OK.getCode(), ResponseType.OK, "Action executed");
    }
}
