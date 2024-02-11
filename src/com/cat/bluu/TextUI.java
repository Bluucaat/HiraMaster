package com.cat.bluu;

import java.io.IOException;
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
            if (userChoice == 1) {
                try {
                    DataObject phrase = service.genPhrase();

                    System.out.printf("Phrase: %s%nRomaji equivalent:", phrase.getJapanese());
                    System.out.println(validateAnswer(phrase));
                } catch (IOException exception) {
                    System.out.println("An error occured while executing the program:\n");
                    exception.printStackTrace();
                }

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
        try {
            String japanese = phrase.getJapanese();
            String romaji = phrase.getRomaji();
            String translation = phrase.getTranslation();
            String mappedWord = service.generateRomaji(phrase.getJapanese());
            String userWord = readWordInput().strip().replace(" ", "");
//          String accuracy = service.checkAccuracy(userWord);
            String requiredWord = romaji.strip().replace(" ", "");

            if (userWord.equalsIgnoreCase(requiredWord)) {
                return answer("correct", japanese, romaji, translation, mappedWord);
            } else {
                return answer("incorrect", japanese, romaji, translation, mappedWord);
            }
        } catch (IOException exception) {
            System.out.println("An error occured while executing the program:\n");
            exception.printStackTrace();
        }
        return null;
    }

    public static String answer(String result, String japanese, String romaji, String translation, String mappedWord) {
        return String.format("-".repeat(30) +
                        "%nYour answer is %s.%nWord: %s%n" +
                        "Romaji: %s%n" +
                        "Meaning: %s%n" +
                        "Mapped word: %s%n" +
                        "-".repeat(30) + "%n",
                result, japanese, romaji, translation, mappedWord);
    }
}
