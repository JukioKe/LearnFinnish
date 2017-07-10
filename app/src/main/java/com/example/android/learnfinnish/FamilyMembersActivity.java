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

public class FamilyMembersActivity extends AppCompatActivity {

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
        final ArrayList<Word> familyWords = new ArrayList<Word>();

        //Create all Word objects for Family category
        familyWords.add(new Word("perhe", "family", R.drawable.family_family, R.raw.number_zero));
        familyWords.add(new Word("isä", "father", R.drawable.family_father, R.raw.number_zero));
        familyWords.add(new Word("äiti", "mother", R.drawable.family_mother, R.raw.number_zero));
        familyWords.add(new Word("poika", "son", R.drawable.family_son, R.raw.number_zero));
        familyWords.add(new Word("tytär", "daughter", R.drawable.family_daughter, R.raw.number_zero));
        familyWords.add(new Word("veli", "brother", R.drawable.family_son, R.raw.number_zero));
        familyWords.add(new Word("isoveli", "big brother", R.drawable.family_older_brother, R.raw.number_zero));
        familyWords.add(new Word("pikkuveli", "younger brother", R.drawable.family_son, R.raw.number_zero));
        familyWords.add(new Word("isosisko", "older sister", R.drawable.family_older_sister, R.raw.number_zero));
        familyWords.add(new Word("pikkusisko", "younger sister", R.drawable.family_daughter, R.raw.number_zero));
        familyWords.add(new Word("isoäiti", "grandmother", R.drawable.family_grandmother, R.raw.number_zero));
        familyWords.add(new Word("isoisä", "grandfather", R.drawable.family_grandfather, R.raw.number_zero));
        familyWords.add(new Word("lapsenlapsi", "grandchild", R.drawable.family_baby, R.raw.number_zero));
        familyWords.add(new Word("setä", "uncle", R.drawable.family_uncle, R.raw.number_zero));
        familyWords.add(new Word("täti", "aunt", R.drawable.family_aunt, R.raw.number_zero));
        familyWords.add(new Word("vanhemmat", "parents", R.drawable.family_parents, R.raw.number_zero));
        familyWords.add(new Word("lapsi", "child", R.drawable.family_daughter, R.raw.number_zero));
        familyWords.add(new Word("veljenpoika", "nephew", R.drawable.family_son, R.raw.number_zero));
        familyWords.add(new Word("veljentytär", "niece", R.drawable.family_daughter, R.raw.number_zero));
        familyWords.add(new Word("serkku", "cousin", R.drawable.family_cousin, R.raw.number_zero));
        familyWords.add(new Word("aviomies", "husband", R.drawable.family_husband, R.raw.number_zero));
        familyWords.add(new Word("vaimo", "wife", R.drawable.family_wife, R.raw.number_zero));
        familyWords.add(new Word("kummisetä", "godfather", R.drawable.family_godfather, R.raw.number_zero));
        familyWords.add(new Word("vauva", "baby", R.drawable.family_baby, R.raw.number_zero));
        familyWords.add(new Word("sukulainen", "relative", R.drawable.family_relative, R.raw.number_zero));

        //Create new WordAdapter and give this(FamilyActivity) context
        WordAdapter adapter = new WordAdapter(this, familyWords, R.color.category_family);

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
                Word wordJustClicked = familyWords.get(position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, wordJustClicked.getAudioResourceID());
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
