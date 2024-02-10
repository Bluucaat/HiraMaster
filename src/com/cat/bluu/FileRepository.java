package com.cat.bluu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRepository extends Repository {
    private String name;

    public FileRepository(String name) {
        this.name = name;
    }

    @Override
    ArrayList<DataObject> getData() {
        ArrayList<DataObject> data = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(this.name));

            String line;
            while ((line = br.readLine()) != null) {
                DataObject dataObject = new DataObject(line);
                data.add(dataObject);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
