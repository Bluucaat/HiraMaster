package com.cat.bluu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Service {

    private Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public String[] genPhrase() {
        HashMap<String, String> data = repo.getData();
        Random r = new Random();
        int result = r.nextInt(data.size());
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (result == 0) {
                String[] pair = new String[2];
                pair[0] = entry.getKey();
                pair[1] = entry.getValue();

                return pair;
            }
            result--;
        }
        return new String[2];
    }


}
