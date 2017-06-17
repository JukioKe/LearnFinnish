
package com.example.android.learnfinnish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers_view);

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

        // Find the View that shows the family category
        TextView family = (TextView) findViewById(R.id.family_view);

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

        // Find the View that shows the colors category
        TextView colors = (TextView) findViewById(R.id.colors_view);

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

        // Find the View that shows the phrases category
        TextView phrases = (TextView) findViewById(R.id.phrases_view);

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

        // Find the View that shows the sports category
        TextView sports = (TextView) findViewById(R.id.sports_view);

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
        TextView feelings = (TextView) findViewById(R.id.feelings_view);

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

    }


}
