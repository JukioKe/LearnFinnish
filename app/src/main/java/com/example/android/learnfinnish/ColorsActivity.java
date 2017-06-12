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

        colorWords.add(new Word("vihreä", "green"));
        colorWords.add(new Word("punainen", "red"));
        colorWords.add(new Word("sininen", "blue"));
        colorWords.add(new Word("keltainen", "yellow"));
        colorWords.add(new Word("ruskea", "brown"));
        colorWords.add(new Word("harmaa", "grey"));
        colorWords.add(new Word("valkoinen", "white"));
        colorWords.add(new Word("musta", "black"));
        colorWords.add(new Word("purppura", "purple"));
        colorWords.add(new Word("oranssi", "orange"));
        colorWords.add(new Word("turkoosi", "turquoise"));
        colorWords.add(new Word("lila", "lila"));
        colorWords.add(new Word("hopeinen", "silver"));
        colorWords.add(new Word("kultainen", "golden"));


        WordAdapter adapter = new WordAdapter(this, colorWords);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
