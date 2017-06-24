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


        sportWords.add(new Word("joukkue", "team", R.drawable.sports_team));
        sportWords.add(new Word("pelata", "play", R.drawable.sports_play));
        sportWords.add(new Word("voitto", "victory", R.drawable.sports_trophy));
        sportWords.add(new Word("tappio", "defeat", R.drawable.sports_defeat));
        sportWords.add(new Word("urheilija", "athlete", R.drawable.sports_athlete));
        sportWords.add(new Word("pallo", "ball", R.drawable.sports_ball));
        sportWords.add(new Word("maila", "racquet", R.drawable.sports_raquet));
        sportWords.add(new Word("pelaaja", "player", R.drawable.sports_player));
        sportWords.add(new Word("maalivahti", "goalkeeper", R.drawable.sports_goalkeeper));
        sportWords.add(new Word("kenttä", "field", R.drawable.sports_field));
        sportWords.add(new Word("maali", "goal", R.drawable.sports_goal));
        sportWords.add(new Word("verkko", "net", R.drawable.sports_net));
        sportWords.add(new Word("valmentaja", "coach", R.drawable.sports_coach));
        sportWords.add(new Word("piste", "point", R.drawable.sports_point));
        sportWords.add(new Word("mitali", "medal", R.drawable.sports_medal));
        sportWords.add(new Word("palkinto", "trophy", R.drawable.sports_trophy));
        sportWords.add(new Word("paitsio", "offside", R.drawable.sports_offside));
        sportWords.add(new Word("tuomari", "referee", R.drawable.sports_referee));
        sportWords.add(new Word("vierasjoukkue, vastustaja", "away team", R.drawable.sports_away_team));
        sportWords.add(new Word("kotijoukkue", "home team", R.drawable.sports_team));
        sportWords.add(new Word("syötä", "pass", R.drawable.sports_pass));
        sportWords.add(new Word("laukaise, vedä", "shoot", R.drawable.sports_shoot));
        sportWords.add(new Word("kunto", "fitness", R.drawable.sports_fitness));


        WordAdapter adapter = new WordAdapter(this, sportWords, R.color.category_sports);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }
}
