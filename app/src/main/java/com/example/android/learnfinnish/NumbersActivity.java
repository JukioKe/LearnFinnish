package com.example.android.learnfinnish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    public NumbersActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numberWords = new ArrayList<>();

        numberWords.add(new Word("nolla", "zero", R.drawable.number_zero));
        numberWords.add(new Word("yksi", "one", R.drawable.number_one, R.raw.number_one));
        numberWords.add(new Word("kaksi", "two", R.drawable.number_two, R.raw.number_two));
        numberWords.add(new Word("kolme", "three", R.drawable.number_three, R.raw.number_three));
        numberWords.add(new Word("neljä", "four", R.drawable.number_four, R.raw.number_four));
        numberWords.add(new Word("viisi", "five", R.drawable.number_five, R.raw.number_five));
        numberWords.add(new Word("kuusi", "six", R.drawable.number_six, R.raw.number_six));
        numberWords.add(new Word("seitsemän", "seven", R.drawable.number_seven, R.raw.number_seven));
        numberWords.add(new Word("kahdeksan", "eight", R.drawable.number_eight, R.raw.number_eight));
        numberWords.add(new Word("yhdeksän", "nine", R.drawable.number_nine, R.raw.number_nine));
        numberWords.add(new Word("kymmenen", "ten", R.drawable.number_ten, R.raw.number_ten));
        numberWords.add(new Word("yksitoista", "eleven", R.drawable.number_eleven));
        numberWords.add(new Word("kaksitoista", "twelve", R.drawable.number_twelve));
        numberWords.add(new Word("kolmetoista", "thirteen", R.drawable.number_thirteen));
        numberWords.add(new Word("neljätoista", "fourteen", R.drawable.number_fourteen));
        numberWords.add(new Word("viisitoista", "fiveteen", R.drawable.number_fiveteen));
        numberWords.add(new Word("kuusitoista", "sixteen", R.drawable.number_sixteen));
        numberWords.add(new Word("seitsemäntoista", "seventeen", R.drawable.number_seventeen));
        numberWords.add(new Word("kahdeksantoista", "eighteen", R.drawable.number_eighteen));
        numberWords.add(new Word("yhdeksäntoista", "nineteen", R.drawable.number_nineteen));
        numberWords.add(new Word("kaksikymmentä", "twenty", R.drawable.number_twenty));


        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int audioResourceID = numberWords.get(position).getAudioResourceID();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, audioResourceID);
                mediaPlayer.start();

                Toast.makeText(NumbersActivity.this, "Toimiiko!!!!", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
