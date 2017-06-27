package com.example.android.learnfinnish;

//Word object is word that user want's to learn. It contains image recourse ID, Finnish word and English translation of that word.

public class Word {
    private String finTransalation;
    private String engTranslation;
    private int audioResourceID;
    private int imageResourceID;

    public Word(String finTransalation, String engTranslation, int imageResourceID, int audioResourceID) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
        this.imageResourceID = imageResourceID;
        this.audioResourceID = audioResourceID;
    }

    public Word(String finTransalation, String engTranslation, int imageResourceID) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
        this.imageResourceID = imageResourceID;
    }

    public Word(String finTransalation, String engTranslation) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
    }

    public String getEngTranslation() {
        return engTranslation;
    }

    public String getFinTranslation() {
        return finTransalation;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getAudioResourceID() {
        return audioResourceID;
    }

}
