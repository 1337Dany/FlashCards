package org.example.flashcards.ui.menu;

import org.example.flashcards.ui.Game;

public class Menu extends Game {
    private final MenuCallback menuCallback;

    public Menu(MenuCallback menuCallback) {
        this.menuCallback = menuCallback;
    }

    public void init(){
        System.out.println(GREEN + "Welcome to Flashcards!" + RESET);
        System.out.println(YELLOW + "Please choose an option:" + RESET);

        while (true) {
            menuInput();
        }
    }

    private void menuInput() {
        System.out.println(YELLOW + "1. Start and test" + RESET);
        System.out.println(YELLOW + "2. Display all entries" + RESET);
        System.out.println(YELLOW + "3. Add entry" + RESET);
        System.out.println(YELLOW + "4. Exit" + RESET);
        System.out.print(BLUE + "Your choice: " + RESET);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                start();
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

    private void start() {
        System.out.println(GREEN + "Starting the quiz!" + RESET);
        System.out.println(YELLOW + "Press 0 to open menu" + RESET);
        System.out.println(YELLOW + "Choose the language of cards: 1.Polish 2.English 3.German" + RESET);
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                menuCallback.startPolishFlashcards();
                break;
            case 2:
                menuCallback.startEnglishFlashcards();
                break;
            case 3:
                menuCallback.startGermanFlashcards();
                break;
            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
    }

    private void displayAll() {
        System.out.println(menuCallback.displayAll());
    }

    private void addEntry() {
        System.out.print(BLUE + "Enter the entry (Polish, English, German): " + RESET);
        String entry = scanner.nextLine();
        menuCallback.addEntry(entry);
    }


}
