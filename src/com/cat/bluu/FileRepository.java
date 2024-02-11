package com.cat.bluu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileRepository extends Repository {
    private final String file1;
    private final String file2;

    public FileRepository(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    @Override
    ArrayList<DataObject> getPhraseData() throws IOException {

        ArrayList<DataObject> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(this.file1));
        String line;

        while ((line = br.readLine()) != null) {
            DataObject dataObject = new DataObject(line);
            data.add(dataObject);
        }
        return data;
    }

    @Override
    HashMap<String, String> hiraganaMap() throws IOException {

        HashMap<String, String> mapData = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(this.file2));
        String line;

        while ((line = br.readLine()) != null) {
            String[] wordsInLine = line.split("\t");
            for (String s : wordsInLine) {
                String[] word = s.split(" ");
                mapData.put(word[0], word[1]);
            }
        }
        return mapData;
    }
}
