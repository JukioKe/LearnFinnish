package com.example.android.learnfinnish;

// Color object

public class Color {
    private String finTranslation;
    private String engTranslation;

    public Color(String finTranslation, String engTranslation) {
        this.finTranslation = finTranslation;
        this.engTranslation = engTranslation;
    }

    public String getFinTranslation() {
        return finTranslation;
    }

    public String getEngTranslation() {
        return engTranslation;
    }

}
