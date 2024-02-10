package com.cat.bluu;

public class Main {
    public static void main(String[] args) {

        Repository repo = new FileRepository("data/hiragana.txt");
        Service service = new Service(repo);
        UI ui = new TextUI(service);
        ui.run();

    }
}
