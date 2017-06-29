package com.example.android.learnfinnish;

//Word object is word that user want's to learn. It contains image recourse ID, Finnish word and English translation of that word.

class Word {
    private String finTransalation;
    private String engTranslation;
    private int audioResourceID;
    private int imageResourceID;

    Word(String finTransalation, String engTranslation, int imageResourceID, int audioResourceID) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
        this.imageResourceID = imageResourceID;
        this.audioResourceID = audioResourceID;
    }

    Word(String finTransalation, String engTranslation, int imageResourceID) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
        this.imageResourceID = imageResourceID;
    }

    public Word(String finTransalation, String engTranslation) {
        this.finTransalation = finTransalation;
        this.engTranslation = engTranslation;
    }

    String getEngTranslation() {
        return engTranslation;
    }

    String getFinTranslation() {
        return finTransalation;
    }

    int getImageResourceID() {
        return imageResourceID;
    }

    int getAudioResourceID() {
        return audioResourceID;
    }

    @Override
    public String toString() {
        return "Word{" +
                "finTransalation='" + finTransalation + '\'' +
                ", engTranslation='" + engTranslation + '\'' +
                ", audioResourceID=" + audioResourceID +
                ", imageResourceID=" + imageResourceID +
                '}';
    }
}
