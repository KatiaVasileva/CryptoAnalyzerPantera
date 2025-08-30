package com.javarush.vasileva.view;

import com.javarush.vasileva.controller.Controller;
import com.javarush.vasileva.entity.Request;
import com.javarush.vasileva.entity.Response;

import java.util.Scanner;

public class ConsoleMenu {
    Controller controller = new Controller();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose the action (enter 1, 2 or 0):");
            System.out.println("1 - Encrypt");
            System.out.println("2 - Decrypt");
            System.out.println("0 - Exit");
            System.out.println("****************");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            Request request = new Request();

            if (choice == 1 || choice == 2) {
                System.out.println("Enter the path of the source file: ");
                scanner.nextLine();
                request.setSourceFile(scanner.nextLine());
                System.out.println("Enter the path of the target file: ");
                request.setTargetFile(scanner.nextLine());
                System.out.print("Enter the key: ");
                request.setKey(scanner.nextInt());
                Response response = controller.doAction(request, choice);
                System.out.println("\n" + response.getCode());
                System.out.println(response.getType());
                System.out.println(response.getMessage());
            } else if (choice == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println("****************");
            System.out.println("Continue? (Y/N)");
            if (scanner.next().equals("N")) {
                System.exit(0);
            }
            System.out.println("****************");
        }
    }
}
