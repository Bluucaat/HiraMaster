package com.cat.bluu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class FileRepository extends Repository {
    private String name;

    public FileRepository(String name) {
        this.name = name;
    }

    @Override
    HashMap<String, String> getData() {
        HashMap<String, String> data = new HashMap<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(this.name));

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(";");
                data.put(lineData[0], lineData[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
