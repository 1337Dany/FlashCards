package org.example.flashcardsrebased.ui.gamemode;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.ui.Game;
import org.example.flashcardsrebased.ui.profiles.formatters.EntryFormatter;

public class FlashCards extends Game {
    private final GameContract gameContract;
    private final EntryFormatter entryFormatter;

    public FlashCards(GameContract gameContract, EntryFormatter entryFormatter) {
        this.gameContract = gameContract;
        this.entryFormatter = entryFormatter;
    }

    public void start(String language) {
        String engWord;
        String polWord;
        String gerWord;

        while (true) {
            Entry entry = gameContract.getRandomEntry();
            engWord = entryFormatter.format(entry.english());
            polWord = entryFormatter.format(entry.polish());
            gerWord = entryFormatter.format(entry.german());

            System.out.println();
            System.out.println(YELLOW + "Word: " +
                    (language.equals("german") ? gerWord : language.equals("english") ? engWord : polWord)
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
                    (language.equals("german") ? engWord : language.equals("english") ? polWord : gerWord)
                            .toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" +
                        (language.equals("german") ? engWord : language.equals("english") ? polWord : gerWord)
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
                    (language.equals("german") ? polWord : language.equals("english") ? gerWord : engWord)
                            .toLowerCase())) {
                System.out.println(GREEN + "Correct!" + RESET);
            } else {
                System.out.println(RED + "Wrong answer. The correct one is \"" +
                        (language.equals("german") ? polWord : language.equals("english") ? gerWord : engWord)
                        + "\"." + RESET);
            }
        }
    }
}

