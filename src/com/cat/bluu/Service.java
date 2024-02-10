package com.cat.bluu;

import java.util.ArrayList;
import java.util.Random;

public class Service {

    private Repository repo;
    public Service(Repository repo) {
        this.repo = repo;
    }

    public DataObject genPhrase() {
        ArrayList<DataObject> data = repo.getData();
        Random r = new Random();
        int result = r.nextInt(data.size());
        return data.get(result);
    }


}
