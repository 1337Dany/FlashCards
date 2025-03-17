package org.example.flashcards.ui;

import org.example.flashcards.domain.ControllerContract;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {
    private ControllerContract flashCardsController;
    private Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    public View(ControllerContract flashCardsController) {
        this.flashCardsController = flashCardsController;

        init();
    }

    private void init() {
        System.out.println(GREEN + "Welcome to Flashcards!" + RESET);
        System.out.println(YELLOW + "Please choose an option:" + RESET);

        while (true) {
            handleUserInput();
        }
    }

    private void handleUserInput() {
        System.out.println(YELLOW + "1. Start" + RESET);
        System.out.println(YELLOW + "2. Display all entries" + RESET);
        System.out.println(YELLOW + "3. Add entry" + RESET);
        System.out.println(YELLOW + "4. Exit" + RESET);
        System.out.print(BLUE + "Your choice: " + RESET);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                //addEntry();
                break;
            case 2:
                displayAll();
                break;
            case 3:
                addEntry();
                break;
            case 4:
                System.out.println(RED + "Goodbye!" + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
    }

    private void displayAll() {
        System.out.println(flashCardsController.displayAll());
    }

    private void addEntry() {
        System.out.print(BLUE + "Enter the entry (Polish, English, German): " + RESET);
        String entry = scanner.nextLine();
        flashCardsController.add(entry);
    }
}
