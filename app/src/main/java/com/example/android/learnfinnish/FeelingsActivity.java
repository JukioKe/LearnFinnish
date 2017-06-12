package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FeelingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> feelingsWords = new ArrayList<Word>();

        feelingsWords.add(new Word("iloinen", "happy"));
        feelingsWords.add(new Word("surullinen", "sad"));
        feelingsWords.add(new Word("hyvä olo", "good feel"));
        feelingsWords.add(new Word("epätoivo", "despair"));
        feelingsWords.add(new Word("hämmennys", "bewilderment"));
        feelingsWords.add(new Word("häpeä", "shame"));
        feelingsWords.add(new Word("ikävä", "tedious"));
        feelingsWords.add(new Word("intohimo", "passion"));
        feelingsWords.add(new Word("jännitys", "excitement"));
        feelingsWords.add(new Word("kaipaus", "yearning"));
        feelingsWords.add(new Word("kauhu", "fright"));
        feelingsWords.add(new Word("kiinnostus", "interest"));
        feelingsWords.add(new Word("kunnioitus", "respect"));
        feelingsWords.add(new Word("levottomuus", "anxiety"));
        feelingsWords.add(new Word("luottamus", "confidence"));
        feelingsWords.add(new Word("onni", "luck"));
        feelingsWords.add(new Word("rakkaus", "love"));
        feelingsWords.add(new Word("syyllisyys", "guilt"));
        feelingsWords.add(new Word("ujo", "shy"));
        feelingsWords.add(new Word("viha", "anger"));
        feelingsWords.add(new Word("vapaa", "free"));
        feelingsWords.add(new Word("väsymys", "tiredness"));
        feelingsWords.add(new Word("yksinäisyys", "loneliness"));
        feelingsWords.add(new Word("ylpeys", "pride"));


        WordAdapter adapter = new WordAdapter(this, feelingsWords);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }
}
