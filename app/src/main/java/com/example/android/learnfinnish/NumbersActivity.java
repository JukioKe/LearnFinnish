package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    public NumbersActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numberWords = new ArrayList<>();

        numberWords.add(new Word("yksi", "one"));
        numberWords.add(new Word("kaksi", "two"));
        numberWords.add(new Word("kolme", "three"));
        numberWords.add(new Word("neljä", "four"));
        numberWords.add(new Word("viisi", "five"));
        numberWords.add(new Word("kuusi", "six"));
        numberWords.add(new Word("seitsemän", "seven"));
        numberWords.add(new Word("kahdeksan", "eight"));
        numberWords.add(new Word("yhdeksän", "nine"));
        numberWords.add(new Word("kymmenen", "ten"));
        numberWords.add(new Word("yksitoista", "eleven"));
        numberWords.add(new Word("kaksitoista", "twelve"));
        numberWords.add(new Word("kolmetoista", "thirteen"));
        numberWords.add(new Word("neljätoista", "fourteen"));
        numberWords.add(new Word("viisitoista", "fiveteen"));
        numberWords.add(new Word("kuusitoista", "sixteen"));
        numberWords.add(new Word("seitsemäntoista", "seventeen"));
        numberWords.add(new Word("kahdeksantoista", "eighteen"));
        numberWords.add(new Word("yhdeksäntoista", "nineteen"));
        numberWords.add(new Word("kaksikymmentä", "twenty"));


        WordAdapter adapter = new WordAdapter(this, numberWords);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
