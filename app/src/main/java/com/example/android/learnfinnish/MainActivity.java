
package com.example.android.learnfinnish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the View that shows the numbers category
        RelativeLayout numbers = (RelativeLayout) findViewById(R.id.numbers_layout_view);

        // Set a click listener on that View
        if (numbers != null) {
            numbers.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the numbers View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                    startActivity(numbersIntent);
                }
            });
        }


        // Find the View that shows the colors category
        RelativeLayout colors = (RelativeLayout) findViewById(R.id.colors_layout_view);

        // Set a click listener on that View
        if (colors != null) {
            colors.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the numbers View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                    startActivity(colorsIntent);
                }
            });
        }


        // Find the View that shows the sports category
        RelativeLayout sports = (RelativeLayout) findViewById(R.id.sports_layout_view);

        // Set a click listener on that View
        if (sports != null) {
            sports.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the Sports View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent sportsIntent = new Intent(MainActivity.this, SportsActivity.class);
                    startActivity(sportsIntent);
                }
            });
        }


        // Find the View that shows the feelings category
        RelativeLayout feelings = (RelativeLayout) findViewById(R.id.feelings_layout_view);

        // Set a click listener on that View
        if (feelings != null) {
            feelings.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the Feelings View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent feelingsIntent = new Intent(MainActivity.this, FeelingsActivity.class);
                    startActivity(feelingsIntent);
                }
            });
        }


        // Find the View that shows the family category
        RelativeLayout family = (RelativeLayout) findViewById(R.id.family_layout_view);

        // Set a click listener on that View
        if (family != null) {
            family.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the numbers View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                    startActivity(familyIntent);
                }
            });
        }


        // Find the View that shows the phrases category
        RelativeLayout phrases = (RelativeLayout) findViewById(R.id.phrases_layout_view);

        // Set a click listener on that View
        if (phrases != null) {
            phrases.setOnClickListener(new View.OnClickListener() {
                // The code in this method will be executed when the numbers View is clicked on.
                @Override
                public void onClick(View view) {
                    Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                    startActivity(phrasesIntent);
                }
            });
        }

    }


}
