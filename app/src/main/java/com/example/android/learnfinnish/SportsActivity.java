package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> sportWords = new ArrayList<Word>();

        sportWords.add(new Word("syötä", "pass"));
        sportWords.add(new Word("laukaise, vedä", "shoot"));
        sportWords.add(new Word("katso", "look"));
        sportWords.add(new Word("joukkue", "team"));
        sportWords.add(new Word("vieras joukkue, vastustaja", "away team"));
        sportWords.add(new Word("pelata", "play"));
        sportWords.add(new Word("voitto", "victory"));
        sportWords.add(new Word("tappio", "defeat"));
        sportWords.add(new Word("urheilija", "athlete"));
        sportWords.add(new Word("pallo", "ball"));
        sportWords.add(new Word("maila", "racquet"));
        sportWords.add(new Word("pelaaja", "player"));
        sportWords.add(new Word("maalivahti", "goalkeeper"));
        sportWords.add(new Word("kenttä", "field"));
        sportWords.add(new Word("verkko", "net"));
        sportWords.add(new Word("valmentaja", "coach"));
        sportWords.add(new Word("piste", "point"));
        sportWords.add(new Word("paitsio", "offside"));
        sportWords.add(new Word("tuomari", "referee"));
        sportWords.add(new Word("kunto", "fitness"));


        WordAdapter adapter = new WordAdapter(this, sportWords);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }
}
