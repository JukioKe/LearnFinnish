package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> numberWords = new ArrayList<>();
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        numberWords.addAll(Arrays.asList(words));

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootview);


        for (int index = 0; index < numberWords.size(); index++) {
            TextView wordView = new TextView(this);
            wordView.setText(numberWords.get(index));
            rootView.addView(wordView);

        }

    }
}
