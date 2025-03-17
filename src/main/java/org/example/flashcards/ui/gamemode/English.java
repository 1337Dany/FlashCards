package org.example.flashcards.ui.gamemode;

import org.example.flashcards.data.Entry;
import org.example.flashcards.ui.Game;

public class English extends Game {
    private final GameContract gameContract;

    public English(GameContract gameContract) {
        this.gameContract = gameContract;
    }

    public void start() {
        while (true) {
            Entry entry = gameContract.getRandomEntry();
            System.out.println();
            System.out.println(YELLOW + "Word: " + entry.english() + RESET);
            System.out.println(GREEN + "Translation to German: " + RESET);
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.german().toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.german() + "\"." + RESET);
            }
            System.out.println(GREEN + "Translation to Polish: " + RESET);
            input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.polish().toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.polish() + "\"." + RESET);
            }
        }
    }
}
