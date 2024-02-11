package com.cat.bluu;

public class Main {
    public static void main(String[] args) {

        Repository phraseRepo = new FileRepository("data/phrases.txt", "data/hiraganamap.txt");
        Service phraseGenerator = new Service(phraseRepo);
        UI ui = new TextUI(phraseGenerator);
        ui.run();

    }
}
