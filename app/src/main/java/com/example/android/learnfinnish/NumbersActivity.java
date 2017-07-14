package com.example.android.learnfinnish;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    //This listener gets triggered when Audio Focus state changes
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback because your Audio Focus was
                        // temporarily stolen, but will be back soon.
                        // i.e. for a phone call
                        mediaPlayer.pause();
                        // Start playback over from start
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Stop playback, because you lost the Audio Focus.
                        releaseMediaPlayer();
                    } else if (focusChange ==
                            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Can lower the volume, because something else is also
                        // playing audio over you. But in this app we just pause and start it over.
                        mediaPlayer.pause();
                        // Start playback over from start
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback, because you hold the Audio Focus
                        // again!
                        mediaPlayer.start();
                    }
                }
            };

    //This listener gets triggered when the media player has completed playing the audio file.
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create and setup audio manager to request audio focus
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Create a list for Word objects
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


        //Create new WordAdapter and give this(NumbersActivity) as a context
        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.category_numbers);

        //Create a ListView object and allocate correct XML-layout to it
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

                //Get and store just clicked word object temporarily.
                Word wordJustClicked = numberWords.get(position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, wordJustClicked.getAudioResourceID());
                    mediaPlayer.start();

                    //Set listener to find out when playback is completed to release the media player
                    mediaPlayer.setOnCompletionListener(completionListener);

                }
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

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    // Release resources when activity is stopped
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
