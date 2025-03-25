package org.example.flashcardsrebased.ui.gamemode;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.ui.Game;

public class FlashCards extends Game {
    private final GameContract gameContract;

    public FlashCards(GameContract gameContract, String language) {
        this.gameContract = gameContract;

        start(language);
    }

    public void start(String language) {
        while (true) {
            Entry entry = gameContract.getRandomEntry();
            System.out.println();
            System.out.println(YELLOW + "Word: " +
                    (language.equals("german") ? entry.german() : language.equals("english") ? entry.english() : entry.polish())
                    + RESET);
            System.out.println(GREEN + "Translation to " +
                    (language.equals("german") ? "english" : language.equals("english") ? "polish" : "german")
                    + ": " + RESET);
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(
                    (language.equals("german") ? entry.english() : language.equals("english") ? entry.polish() : entry.german())
                            .toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" +
                        (language.equals("german") ? entry.english() : language.equals("english") ? entry.polish() : entry.german())
                        + "\"." + RESET);
            }
            System.out.println(GREEN + "Translation to " +
                    (language.equals("german") ? "polish" : language.equals("english") ? "german" : "english")
                    + ": " + RESET);
            input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("0")) {
                System.out.println("Game closing...");
                return;
            } else if (input.equals(
                    (language.equals("german") ? entry.polish() : language.equals("english") ? entry.german() : entry.english())
                    .toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" +
                        (language.equals("german") ? entry.polish() : language.equals("english") ? entry.german() : entry.english())
                        + "\"." + RESET);
            }
        }
    }
}

