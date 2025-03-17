package org.example.flashcards.ui.gamemode;

import org.example.flashcards.data.Entry;
import org.example.flashcards.ui.Game;

public class German extends Game {
    private final GameContract gameContract;

    public German(GameContract gameContract) {
        this.gameContract = gameContract;
    }

    public void start() {
        while (true) {
            Entry entry = gameContract.getRandomEntry();
            System.out.println();
            System.out.println(YELLOW + "Word: " + entry.german() + RESET);
            System.out.println(GREEN + "Translation to Polish: " + RESET);
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.polish())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.polish() + "\"." + RESET);
            }
            System.out.println(GREEN + "Translation to English: " + RESET);
            input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.english())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.english() + "\"." + RESET);
            }
        }
    }
}
