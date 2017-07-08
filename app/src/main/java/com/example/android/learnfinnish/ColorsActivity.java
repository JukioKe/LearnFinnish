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

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    //This listener gets triggered when Audio Focus state changes
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
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

        final ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word("vihreä", "green", R.drawable.color_green, R.raw.number_zero));
        colorWords.add(new Word("punainen", "red", R.drawable.color_red, R.raw.number_zero));
        colorWords.add(new Word("sininen", "blue", R.drawable.color_blue, R.raw.number_zero));
        colorWords.add(new Word("keltainen", "yellow", R.drawable.color_yellow, R.raw.number_zero));
        colorWords.add(new Word("ruskea", "brown", R.drawable.color_brown, R.raw.number_zero));
        colorWords.add(new Word("harmaa", "grey", R.drawable.color_gray, R.raw.number_zero));
        colorWords.add(new Word("purppura", "purple", R.drawable.color_purple, R.raw.number_zero));
        colorWords.add(new Word("oranssi", "orange", R.drawable.color_orange, R.raw.number_zero));
        colorWords.add(new Word("turkoosi", "turquoise", R.drawable.color_turquoise, R.raw.number_zero));
        colorWords.add(new Word("lila", "lila", R.drawable.color_lila, R.raw.number_zero));
        colorWords.add(new Word("hopeinen", "silver", R.drawable.color_gray, R.raw.number_zero));
        colorWords.add(new Word("kultainen", "golden", R.drawable.color_golden, R.raw.number_zero));
        colorWords.add(new Word("valkoinen", "white", R.drawable.color_white, R.raw.number_zero));
        colorWords.add(new Word("musta", "black", R.drawable.color_black, R.raw.number_zero));


        WordAdapter adapter = new WordAdapter(this, colorWords, R.color.category_colors);

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
                Word word = colorWords.get(position);

                // Request audio focus in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceID());
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
