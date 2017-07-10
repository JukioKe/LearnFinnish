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

public class SportsActivity extends AppCompatActivity {

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
        final ArrayList<Word> sportWords = new ArrayList<Word>();

        //Create all Word objects for Sports category
        sportWords.add(new Word("joukkue", "team", R.drawable.sports_team, R.raw.number_zero));
        sportWords.add(new Word("pelata", "play", R.drawable.sports_play, R.raw.number_zero));
        sportWords.add(new Word("voitto", "victory", R.drawable.sports_trophy, R.raw.number_zero));
        sportWords.add(new Word("tappio", "defeat", R.drawable.sports_defeat, R.raw.number_zero));
        sportWords.add(new Word("urheilija", "athlete", R.drawable.sports_athlete, R.raw.number_zero));
        sportWords.add(new Word("pallo", "ball", R.drawable.sports_ball, R.raw.number_zero));
        sportWords.add(new Word("maila", "racquet", R.drawable.sports_raquet, R.raw.number_zero));
        sportWords.add(new Word("pelaaja", "player", R.drawable.sports_player, R.raw.number_zero));
        sportWords.add(new Word("maalivahti", "goalkeeper", R.drawable.sports_goalkeeper, R.raw.number_zero));
        sportWords.add(new Word("kenttä", "field", R.drawable.sports_field, R.raw.number_zero));
        sportWords.add(new Word("maali", "goal", R.drawable.sports_goal, R.raw.number_zero));
        sportWords.add(new Word("verkko", "net", R.drawable.sports_net, R.raw.number_zero));
        sportWords.add(new Word("valmentaja", "coach", R.drawable.sports_coach, R.raw.number_zero));
        sportWords.add(new Word("piste", "point", R.drawable.sports_point, R.raw.number_zero));
        sportWords.add(new Word("mitali", "medal", R.drawable.sports_medal, R.raw.number_zero));
        sportWords.add(new Word("palkinto", "trophy", R.drawable.sports_trophy, R.raw.number_zero));
        sportWords.add(new Word("paitsio", "offside", R.drawable.sports_offside, R.raw.number_zero));
        sportWords.add(new Word("tuomari", "referee", R.drawable.sports_referee, R.raw.number_zero));
        sportWords.add(new Word("vierasjoukkue, vastustaja", "away team", R.drawable.sports_away_team, R.raw.number_zero));
        sportWords.add(new Word("kotijoukkue", "home team", R.drawable.sports_team, R.raw.number_zero));
        sportWords.add(new Word("syötä", "pass", R.drawable.sports_pass, R.raw.number_zero));
        sportWords.add(new Word("laukaise, vedä", "shoot", R.drawable.sports_shoot, R.raw.number_zero));
        sportWords.add(new Word("kunto", "fitness", R.drawable.sports_fitness, R.raw.number_zero));

        //Create new WordAdapter and give this(SportsActivity) context
        WordAdapter adapter = new WordAdapter(this, sportWords, R.color.category_sports);

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
                Word wordJustClicked = sportWords.get(position);

                // Request audio focus in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(SportsActivity.this, wordJustClicked.getAudioResourceID());
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

