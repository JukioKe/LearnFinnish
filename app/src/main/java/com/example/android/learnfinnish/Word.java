package com.example.android.learnfinnish;

public class Word {
    private String finTransalation;
    private String engTranslation;

    public Word(String finTransalation, String engTranslation) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
    }

    public String getEngTranslation() {
        return engTranslation;
    }

    public String getFinTransalation() {
        return finTransalation;
    }
}
