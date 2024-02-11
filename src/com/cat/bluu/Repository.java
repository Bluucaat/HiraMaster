package com.cat.bluu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Repository{
    abstract ArrayList<DataObject> getPhraseData() throws IOException;
    abstract HashMap<String, String> hiraganaMap() throws IOException;
}
