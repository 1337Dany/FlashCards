package org.example.flashcardsrebased.ui.menu;

import org.example.flashcardsrebased.ui.Game;

public class Menu extends Game {
    private final MenuCallback menuCallback;

    public Menu(MenuCallback menuCallback) {
        this.menuCallback = menuCallback;
    }

    public void init() {
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
        System.out.println(YELLOW + "4. Delete entry" + RESET);
        System.out.println(YELLOW + "5. Modify entry" + RESET);
        System.out.println(YELLOW + "6. Exit" + RESET);
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
                deleteEntry();
                break;
            case 5:
                modifyEntry();
                break;
            case 6:
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
        System.out.println(GREEN + "Entry added!" + RESET);
    }

    private void deleteEntry(){
        System.out.print(BLUE + "Enter the entry ID: " + RESET);
        long entryId = scanner.nextLong();
        scanner.nextLine();
        menuCallback.deleteEntry(entryId);
        System.out.println(GREEN + "Entry deleted!" + RESET);
    }

    private void modifyEntry(){
        System.out.print(BLUE + "Enter the entry ID: " + RESET);
        long entryId = scanner.nextLong();
        scanner.nextLine();
        System.out.print(BLUE + "Enter the entry (Polish, English, German): " + RESET);
        String entry = scanner.nextLine();
        menuCallback.modifyEntry(entryId, entry);
        System.out.println(GREEN + "Entry modified!" + RESET);
    }

}
