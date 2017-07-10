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

public class PhrasesActivity extends AppCompatActivity {

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

        //Create a list for Word objects
        final ArrayList<Word> phrases = new ArrayList<Word>();

        //Create all Word objects for Phrases category
        phrases.add(new Word("Miten voit?", "how are you?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Voin hyvin", "I'm fine", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Minne olet menossa?", "Where are you going?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Oletko tulossa?", "Are you coming?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Kyllä, olen tulossa", "Yes, I'm coming", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mennään", "Let's go", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Tule tänne", "Come here", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mikä on nimesi?", "What's your name?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Nimeni on...", "My name is...", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Missä asut?", "Where are you living?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Saanko oluen, kiitos?", "Can I have beer, please?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Kiitoksia paljon", "Thank you so much", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Anteeksi", "Excuse me", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mitä mieltä olet?", "What do you think?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Minä opettelen suomen kieltä", "I'm learning Finnish", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("En ymmärrä", "I don't understand", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Voisitko toistaa?", "Could you repeat that, please?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Kiitoksia", "Thank you", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mitä tarkoitat?", "What do you mean?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Hauska tavata", "Nice to meet you", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mistä olet kotoisin?", "Where are you from?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Mitä teet?", "What do you do?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Voinko olla avuksi?", "Can I help you?", R.drawable.color_phrases, R.raw.number_zero));
        phrases.add(new Word("Paljonko kello on?", "What's the time is?", R.drawable.color_phrases, R.raw.number_zero));

        //Create new WordAdapter and give this(PhrasesActivity) context
        WordAdapter adapter = new WordAdapter(this, phrases, R.color.category_phrases);

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
                Word wordJustClicked = phrases.get(position);

                // Request audio focus in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int audioFocusResult = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Create and setup the MediaPlayer for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this, wordJustClicked.getAudioResourceID());
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
