package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word("Miten voit?", "how are you?"));
        phrases.add(new Word("Voin hyvin", "I'm fine"));
        phrases.add(new Word("Minne olet menossa?", "Where are you going?"));
        phrases.add(new Word("Oletko tulossa?", "Are you coming?"));
        phrases.add(new Word("Kyllä, olen tulossa", "Yes, I'm coming"));
        phrases.add(new Word("Mennään", "Let's go"));
        phrases.add(new Word("Tule tänne", "Come here"));
        phrases.add(new Word("Mikä on nimesi?", "What's your name?"));
        phrases.add(new Word("Nimeni on...", "My name is..."));
        phrases.add(new Word("Missä asut?", "Where are you living?"));
        phrases.add(new Word("Saanko oluen, kiitos?", "Can I have beer, please?"));
        phrases.add(new Word("Kiitoksia paljon", "Thank you so much"));
        phrases.add(new Word("Anteeksi", "Excuse me"));
        phrases.add(new Word("Mitä mieltä olet?", "What do you think?"));
        phrases.add(new Word("Minä opettelen suomen kieltä", "I'm learning Finnish"));
        phrases.add(new Word("En ymmärrä", "I don't understand"));
        phrases.add(new Word("Voisitko toistaa?", "Could you repeat that, please?"));
        phrases.add(new Word("Kiitoksia", "Thank you"));
        phrases.add(new Word("Mitä tarkoitat?", "What do you mean?"));
        phrases.add(new Word("Hauska tavata", "Nice to meet you"));
        phrases.add(new Word("Mistä olet kotoisin?", "Where are you from?"));
        phrases.add(new Word("Mitä teet?", "What do you do?"));
        phrases.add(new Word("Voinko olla avuksi?", "Can I help you?"));
        phrases.add(new Word("Paljonko kello on?", "What's the time is?"));


        WordAdapter adapter = new WordAdapter(this, phrases);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
