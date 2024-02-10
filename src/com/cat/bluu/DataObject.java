package com.cat.bluu;

public class DataObject {
    private final String japanese;
    private final String romaji;
    private final String translation;

    public DataObject(String s) {
        String[] dataRecord = s.split(";");
        this.japanese = dataRecord[0];
        this.romaji = dataRecord[1];
        this.translation = dataRecord[2];
    }

    public String getJapanese() {
        return japanese;
    }

    public String getRomaji() {
        return romaji;
    }

    public String getTranslation() {
        return translation;
    }
}
