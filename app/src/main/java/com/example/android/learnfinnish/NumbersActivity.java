package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> numberWords = new ArrayList<>();
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        numberWords.addAll(Arrays.asList(words));


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numberWords);

        ListView listView = (ListView) findViewById(R.id.list);

        if (listView != null) {
            listView.setAdapter(itemsAdapter);
        }


    }
}
