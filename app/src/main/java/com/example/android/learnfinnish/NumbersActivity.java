package com.example.android.learnfinnish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    //This listener gets triggered when the media player has completed playing the audio file.

    private MediaPlayer.OnCompletionListener kompletionKuuntelija = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public NumbersActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //Create a list of Word objects
        final ArrayList<Word> numberWords = new ArrayList<>();


        //Create all Word objects for Numbers category
        numberWords.add(new Word("nolla", "zero", R.drawable.number_zero, R.raw.number_zero));
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
        numberWords.add(new Word("yksitoista", "eleven", R.drawable.number_eleven, R.raw.number_eleven));
        numberWords.add(new Word("kaksitoista", "twelve", R.drawable.number_twelve, R.raw.number_twelve));
        numberWords.add(new Word("kolmetoista", "thirteen", R.drawable.number_thirteen, R.raw.number_thirteen));
        numberWords.add(new Word("neljätoista", "fourteen", R.drawable.number_fourteen, R.raw.number_fourteen));
        numberWords.add(new Word("viisitoista", "fiveteen", R.drawable.number_fiveteen, R.raw.number_fiveteen));
        numberWords.add(new Word("kuusitoista", "sixteen", R.drawable.number_sixteen, R.raw.number_sixteen));
        numberWords.add(new Word("seitsemäntoista", "seventeen", R.drawable.number_seventeen, R.raw.number_seventeen));
        numberWords.add(new Word("kahdeksantoista", "eighteen", R.drawable.number_eighteen, R.raw.number_eighteen));
        numberWords.add(new Word("yhdeksäntoista", "nineteen", R.drawable.number_nineteen, R.raw.number_nineteen));
        numberWords.add(new Word("kaksikymmentä", "twenty", R.drawable.number_twenty, R.raw.number_twenty));


        //Create new WordAdapter and give this(NumbersActivity) context
        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

        // Set a click listener to play the audio when the list item is clicked on
        assert listView != null;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                Word word = numberWords.get(position);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceID());
                mediaPlayer.start();

                //Set listener to find out when playback is completed to release the media player
                mediaPlayer.setOnCompletionListener(kompletionKuuntelija);
            }
        });
    }

    //Clean up the media player by releasing its resources.
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources because we
            // no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For this code, it's decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
