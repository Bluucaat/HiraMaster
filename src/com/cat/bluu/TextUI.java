package com.cat.bluu;

import java.util.Scanner;

public class TextUI extends UI {

    public TextUI(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {
            printOptions();
            int userChoice = readOptionInput();
            //switch would be nicer but "if" leads to less indentation
            if (userChoice == 1) {
                DataObject phrase = service.genPhrase();
                System.out.printf("Phrase: %s%nRomaji equivalent:", phrase.getJapanese());
                System.out.println(validateAnswer(phrase));
            } else if (userChoice == 2) {
                System.out.println("Quitting.");
                return;
            } else {
                System.out.println("Incorrect input");
            }
        }
    }

    private void printOptions() {
        System.out.println("(1) - New Phrase.");
        System.out.println("(2) - Quit.");
        System.out.println("\nWhat do you want to do?");
    }

    private int readOptionInput() {
        Scanner sc = new Scanner(System.in);
        int input;
        try {
            input = sc.nextInt();
        } catch (Exception e) {
            input = 0;
        }
        return input;
    }

    private String readWordInput() {
        Scanner sc = new Scanner(System.in);
        String input;
        try {
            input = sc.nextLine();
        } catch (Exception e) {
            input = "";
        }
        return input;
    }


    public String validateAnswer(DataObject phrase) {
        String japanese = phrase.getJapanese();
        String romaji = phrase.getRomaji();
        String translation = phrase.getTranslation();

        String userWord = readWordInput().strip().replace(" ", "");
        String requiredWord = romaji.strip().replace(" ", "");
        if (userWord.equalsIgnoreCase(requiredWord)) {
            return answer("correct", japanese, romaji, translation);
        } else {
            return answer("incorrect", japanese, romaji, translation);

        }
    }

    public static String answer(String result, String japanese, String romaji, String translation) {
        return String.format("-".repeat(30) +
                        "%nYour answer is %s.%nWord: %s%n" +
                        "Romaji: %s%n" +
                        "Meaning: %s%n" +
                        "-".repeat(30) + "%n",
                result, japanese, romaji, translation);
    }
}
