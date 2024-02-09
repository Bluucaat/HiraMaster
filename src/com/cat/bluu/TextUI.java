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

            switch (userChoice) {
                case 1 -> {
                    String[] data = service.genPhrase();
                    System.out.println("Phrase: " + data[0]);
                    String userWord = readWordInput();
                    if((userWord.equalsIgnoreCase(data[1]))){
                        System.out.println("Waow u win");
                    }else{
                        System.out.println("Waow u suck");
                    }

                }
                case 2 -> {
                    System.out.println("Quitting.");
                    return;
                }
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

}
