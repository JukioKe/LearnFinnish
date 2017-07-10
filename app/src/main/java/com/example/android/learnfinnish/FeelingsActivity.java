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

public class FeelingsActivity extends AppCompatActivity {

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
        final ArrayList<Word> feelingsWords = new ArrayList<Word>();

        //Create all Word objects for Feelings category
        feelingsWords.add(new Word("iloinen", "happy", R.drawable.feeling_happy, R.raw.number_zero));
        feelingsWords.add(new Word("surullinen", "sad", R.drawable.feeling_sad, R.raw.number_zero));
        feelingsWords.add(new Word("hyvä olo", "good feel", R.drawable.feeling_good_feel, R.raw.number_zero));
        feelingsWords.add(new Word("epätoivo", "despair", R.drawable.feeling_despair, R.raw.number_zero));
        feelingsWords.add(new Word("hämmennys", "bewilderment", R.drawable.feeling_bewilderment, R.raw.number_zero));
        feelingsWords.add(new Word("häpeä", "shame", R.drawable.feeling_shame, R.raw.number_zero));
        feelingsWords.add(new Word("ikävä", "tedious", R.drawable.feeling_tedious, R.raw.number_zero));
        feelingsWords.add(new Word("intohimo", "passion", R.drawable.feeling_passion, R.raw.number_zero));
        feelingsWords.add(new Word("jännitys", "excitement", R.drawable.feeling_excitement, R.raw.number_zero));
        feelingsWords.add(new Word("kaipaus", "yearning", R.drawable.feeling_yearning, R.raw.number_zero));
        feelingsWords.add(new Word("kauhu", "fright", R.drawable.feeling_fright, R.raw.number_zero));
        feelingsWords.add(new Word("kiinnostus", "interest", R.drawable.feeling_interest, R.raw.number_zero));
        feelingsWords.add(new Word("kunnioitus", "respect", R.drawable.feeling_respect, R.raw.number_zero));
        feelingsWords.add(new Word("levottomuus", "anxiety", R.drawable.feeling_anxiety, R.raw.number_zero));
        feelingsWords.add(new Word("luottamus", "confidence", R.drawable.feeling_confident, R.raw.number_zero));
        feelingsWords.add(new Word("onni", "luck", R.drawable.feeling_luck, R.raw.number_zero));
        feelingsWords.add(new Word("rakkaus", "love", R.drawable.feeling_love, R.raw.number_zero));
        feelingsWords.add(new Word("syyllisyys", "guilt", R.drawable.feeling_guilty, R.raw.number_zero));
        feelingsWords.add(new Word("ujo", "shy", R.drawable.feeling_shy, R.raw.number_zero));
        feelingsWords.add(new Word("viha", "anger", R.drawable.feeling_angry, R.raw.number_zero));
        feelingsWords.add(new Word("vapaa", "free", R.drawable.feeling_free, R.raw.number_zero));
        feelingsWords.add(new Word("kipeä", "sick", R.drawable.feeling_sick, R.raw.number_zero));
        feelingsWords.add(new Word("väsymys", "tiredness", R.drawable.feeling_tiredness, R.raw.number_zero));
        feelingsWords.add(new Word("yksinäisyys", "loneliness", R.drawable.feeling_lonely, R.raw.number_zero));
        feelingsWords.add(new Word("ylpeys", "pride", R.drawable.feeling_pride, R.raw.number_zero));

        //Create new WordAdapter and give this(FeelingsActivity) context
        WordAdapter adapter = new WordAdapter(this, feelingsWords, R.color.category_feelings);

        //Create a ListView object and allocate correct XML-layout to it
        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long Id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                //Get and store just clicked word object temporarily.
                Word wordJustClicked = feelingsWords.get(position);

                // Request audio focus in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(FeelingsActivity.this, wordJustClicked.getAudioResourceID());
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
