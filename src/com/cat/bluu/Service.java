package com.cat.bluu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Service {

    private final Repository phraseRepo;

    public Service(Repository phraseRepo) {
        this.phraseRepo = phraseRepo;
    }

    public DataObject genPhrase() throws IOException {
        ArrayList<DataObject> phraseData = phraseRepo.getPhraseData();
        Random r = new Random();
        int result = r.nextInt(phraseData.size());
        return phraseData.get(result);
    }

    //this will give the user a more detailed review of which part of the word they got wrong and right, as well as their accuracy.
    //TODO
    public String checkAccuracy(String userPhrase) throws IOException {
        HashMap<String, String> mapData = phraseRepo.hiraganaMap();
        String mappedWord = "";
        int wordScore = 0;

        // convert

        for (Map.Entry<String, String> entry : mapData.entrySet()) {
            int index = 0;
            String romaLetter = entry.getValue();
            String userLetter = userPhrase.substring(index, index + romaLetter.length() - 1);
            if (romaLetter.equalsIgnoreCase(userLetter)) {
                wordScore += 1;
                index += romaLetter.length() - 1;
                break;
            }
        }
        return "";
    }

    public String generateRomaji(String phrase) throws IOException {
        StringBuilder generatedWord = new StringBuilder();
        HashMap<String, String> mapData = phraseRepo.hiraganaMap();
        for (int i = 0; i < phrase.length(); i++) {
            String character = String.valueOf(phrase.charAt(i));
            String combination = "";
            if (i != phrase.length() - 1) {
                combination = String.valueOf(phrase.charAt(i)).concat(String.valueOf(phrase.charAt(i + 1)));
            }
            if (mapData.containsKey(combination)) {
                generatedWord.append(mapData.get(combination));
                i++;
            } else {
                generatedWord.append(mapData.get(character));

            }
        }
        return generatedWord.toString();
    }
}
