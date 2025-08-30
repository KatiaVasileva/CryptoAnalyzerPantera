package com.javarush.vasileva.view;

import com.javarush.vasileva.controller.Controller;
import com.javarush.vasileva.entity.Request;
import com.javarush.vasileva.entity.Response;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.vasileva.constant.Messages.choiceMessages;
import static com.javarush.vasileva.constant.Messages.menuMessages;

public class ConsoleMenu {
    Controller controller = new Controller();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (String s : menuMessages) {
                System.out.println(s);
            }

            try {
                int choice = Integer.parseInt(scanner.next());
                Request request = new Request();

                if (choice == 1 || choice == 2 || choice == 3) {
                    scanner.nextLine();
                    String[] messages = choiceMessages.get(choice);
                    String[] args = new String[messages.length];

                    for (int i = 0; i < messages.length; i++) {
                        System.out.println(messages[i]);
                        args[i] = scanner.next();
                    }

                    request.setSourceFile(args[0]);
                    request.setTargetFile(args[1]);

                    if (args.length == 3) {
                        request.setKey(Integer.parseInt(args[2]));
                    }

                    Response response = controller.doAction(request, choice);
                    System.out.println("\n" + response.code());
                    System.out.println(response.type());
                    System.out.println(response.message());
                } else if (choice == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Enter 0, 1, 2 or 3");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid choice. Enter number");
            }

            System.out.println("****************");
            while (true) {
                System.out.println("Continue? (Y/N)");
                String continueResponse = scanner.next();
                if (continueResponse.equalsIgnoreCase("N")) {
                    System.exit(0);
                }
                if (!continueResponse.equalsIgnoreCase("Y")) {
                    System.out.println("Enter Y or N");
                    continue;
                }
                System.out.println("****************");
                break;
            }
        }
    }
}
