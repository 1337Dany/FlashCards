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
            System.out.println(GREEN + "Word: " + entry.getGerman() + RESET);
            System.out.println(GREEN + "Translation to Polish: " + RESET);
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.getPolish())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.getPolish() + "\"." + RESET);
            }
            System.out.println(GREEN + "Translation to English: " + RESET);
            input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(entry.getEnglish())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" + entry.getEnglish() + "\"." + RESET);
            }
        }
    }
}
