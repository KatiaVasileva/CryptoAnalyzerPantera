package com.javarush.vasileva.constant;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    public static String[] menuMessages = {
            "Choose the action (enter 1, 2, 3 or 0):",
            "1 - Encrypt",
            "2 - Decrypt",
            "3 - Brute Force",
            "0 - Exit",
            "****************",
            "Your choice: "
    };

    public static Map<Integer, String[]> choiceMessages = new HashMap<>();

    static {
        choiceMessages.put(1, new String[] {
                "Enter the name of the original file: ",
                "Enter the name of the encrypted file: ",
                "Enter the key: "
        });
        choiceMessages.put(2, new String[] {
                "Enter the name of the encrypted file: ",
                "Enter the name of the decrypted file: ",
                "Enter the key: "
        });
        choiceMessages.put(3, new String[] {
                "Enter the name of the encrypted file: ",
                "Enter the name of the decrypted file: ",
        });
    }
}
