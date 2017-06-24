package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word("vihreä", "green", R.drawable.color_green));
        colorWords.add(new Word("punainen", "red", R.drawable.color_red));
        colorWords.add(new Word("sininen", "blue", R.drawable.color_blue));
        colorWords.add(new Word("keltainen", "yellow", R.drawable.color_yellow));
        colorWords.add(new Word("ruskea", "brown", R.drawable.color_brown));
        colorWords.add(new Word("harmaa", "grey", R.drawable.color_gray));
        colorWords.add(new Word("purppura", "purple", R.drawable.color_purple));
        colorWords.add(new Word("oranssi", "orange", R.drawable.color_orange));
        colorWords.add(new Word("turkoosi", "turquoise", R.drawable.color_turquoise));
        colorWords.add(new Word("lila", "lila", R.drawable.color_lila));
        colorWords.add(new Word("hopeinen", "silver", R.drawable.color_gray));
        colorWords.add(new Word("kultainen", "golden", R.drawable.color_golden));
        colorWords.add(new Word("valkoinen", "white", R.drawable.color_white));
        colorWords.add(new Word("musta", "black", R.drawable.color_black));


        WordAdapter adapter = new WordAdapter(this, colorWords, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
