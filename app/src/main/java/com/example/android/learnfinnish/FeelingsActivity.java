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

        feelingsWords.add(new Word("iloinen", "happy", R.drawable.feeling_happy));
        feelingsWords.add(new Word("surullinen", "sad", R.drawable.feeling_sad));
        feelingsWords.add(new Word("hyvä olo", "good feel", R.drawable.feeling_good_feel));
        feelingsWords.add(new Word("epätoivo", "despair", R.drawable.feeling_despair));
        feelingsWords.add(new Word("hämmennys", "bewilderment", R.drawable.feeling_bewilderment));
        feelingsWords.add(new Word("häpeä", "shame", R.drawable.feeling_shame));
        feelingsWords.add(new Word("ikävä", "tedious", R.drawable.feeling_tedious));
        feelingsWords.add(new Word("intohimo", "passion", R.drawable.feeling_passion));
        feelingsWords.add(new Word("jännitys", "excitement", R.drawable.feeling_excitement));
        feelingsWords.add(new Word("kaipaus", "yearning", R.drawable.feeling_yearning));
        feelingsWords.add(new Word("kauhu", "fright", R.drawable.feeling_fright));
        feelingsWords.add(new Word("kiinnostus", "interest", R.drawable.feeling_interest));
        feelingsWords.add(new Word("kunnioitus", "respect", R.drawable.feeling_respect));
        feelingsWords.add(new Word("levottomuus", "anxiety", R.drawable.feeling_anxiety));
        feelingsWords.add(new Word("luottamus", "confidence", R.drawable.feeling_confident));
        feelingsWords.add(new Word("onni", "luck", R.drawable.feeling_luck));
        feelingsWords.add(new Word("rakkaus", "love", R.drawable.feeling_love));
        feelingsWords.add(new Word("syyllisyys", "guilt", R.drawable.feeling_guilty));
        feelingsWords.add(new Word("ujo", "shy", R.drawable.feeling_shy));
        feelingsWords.add(new Word("viha", "anger", R.drawable.feeling_angry));
        feelingsWords.add(new Word("vapaa", "free", R.drawable.feeling_free));
        feelingsWords.add(new Word("kipeä", "sick", R.drawable.feeling_sick));
        feelingsWords.add(new Word("väsymys", "tiredness", R.drawable.feeling_tiredness));
        feelingsWords.add(new Word("yksinäisyys", "loneliness", R.drawable.feeling_lonely));
        feelingsWords.add(new Word("ylpeys", "pride", R.drawable.feeling_pride));


        WordAdapter adapter = new WordAdapter(this, feelingsWords, R.color.category_feelings);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }
}
