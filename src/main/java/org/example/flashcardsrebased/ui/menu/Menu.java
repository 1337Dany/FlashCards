package org.example.flashcardsrebased.ui.menu;

import org.example.flashcardsrebased.ui.Game;

public class Menu extends Game {
    private final MenuContract menuContract;

    public Menu(MenuContract menuContract) {
        this.menuContract = menuContract;
    }

    public void init() {
        System.out.println(GREEN + "Welcome to Flashcards!" + RESET);
        System.out.println(YELLOW + "Please choose an option:" + RESET);

        while (true) {
            menuInput();
        }
    }

    private void menuInput() {
        System.out.println(YELLOW + "1.   Start and test" + RESET);
        System.out.println(YELLOW + "2. Display all entries" + RESET);
        System.out.println(YELLOW + "3.    Sort entries" + RESET);
        System.out.println(YELLOW + "4.     Find entry" + RESET);
        System.out.println(YELLOW + "5.      Add entry" + RESET);
        System.out.println(YELLOW + "6.     Delete entry" + RESET);
        System.out.println(YELLOW + "7.     Modify entry" + RESET);
        System.out.println(YELLOW + "8.         Exit" + RESET);
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
                displaySorted(chooseSorting());
                break;
            case 4:
                findEntry();
                break;
            case 5:
                addEntry();
                break;
            case 6:
                deleteEntry();
                break;
            case 7:
                modifyEntry();
                break;
            case 8:
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
                menuContract.startPolishFlashcards();
                break;
            case 2:
                menuContract.startEnglishFlashcards();
                break;
            case 3:
                menuContract.startGermanFlashcards();
                break;
            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
    }

    private void displayAll() {
        System.out.println(menuContract.displayAll());
    }

    private void displaySorted(String sorting) {
        System.out.println(menuContract.displayAllSorted(sorting));
    }
    private String chooseSorting() {
        System.out.println(YELLOW + "Choose the sorting: 1.Polish 2.English 3.German" + RESET);
        int choice = scanner.nextInt();
        System.out.println(YELLOW + "Choose sorting: 1. Ascending 2. Descending" + RESET);
        int order = scanner.nextInt();
        switch (choice) {
            case 0:
                return null;
            case 1:
                return order == 1 ? "sort by polish asc" : "sort by polish desc";
            case 2:
                return order == 1 ? "sort by english asc" : "sort by english desc";
            case 3:
                return order == 1 ? "sort by german asc" : "sort by german desc";
            default:
                System.out.println(RED + "Invalid choice!" + RESET);
        }
        return null;
    }

    private void addEntry() {
        System.out.print(BLUE + "Enter the entry (Polish, English, German): " + RESET);
        String entry = scanner.nextLine();
        menuContract.addEntry(entry);
        System.out.println(GREEN + "Entry added!" + RESET);
    }

    private void findEntry(){
        System.out.print(BLUE + "Enter the word: " + RESET);
        String entryId = scanner.nextLine();
        System.out.println(menuContract.findEntry(entryId));
    }

    private void deleteEntry(){
        System.out.print(BLUE + "Enter the entry ID: " + RESET);
        long entryId = scanner.nextLong();
        scanner.nextLine();
        menuContract.deleteEntry(entryId);
        System.out.println(GREEN + "Entry deleted!" + RESET);
    }

    private void modifyEntry(){
        System.out.print(BLUE + "Enter the entry ID: " + RESET);
        long entryId = scanner.nextLong();
        scanner.nextLine();
        System.out.print(BLUE + "Enter the entry (Polish, English, German): " + RESET);
        String entry = scanner.nextLine();
        menuContract.modifyEntry(entryId, entry);
        System.out.println(GREEN + "Entry modified!" + RESET);
    }

}
