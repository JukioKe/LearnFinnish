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

        phrases.add(new Word("Miten voit?", "how are you?", R.drawable.color_phrases));
        phrases.add(new Word("Voin hyvin", "I'm fine", R.drawable.color_phrases));
        phrases.add(new Word("Minne olet menossa?", "Where are you going?", R.drawable.color_phrases));
        phrases.add(new Word("Oletko tulossa?", "Are you coming?", R.drawable.color_phrases));
        phrases.add(new Word("Kyllä, olen tulossa", "Yes, I'm coming", R.drawable.color_phrases));
        phrases.add(new Word("Mennään", "Let's go", R.drawable.color_phrases));
        phrases.add(new Word("Tule tänne", "Come here", R.drawable.color_phrases));
        phrases.add(new Word("Mikä on nimesi?", "What's your name?", R.drawable.color_phrases));
        phrases.add(new Word("Nimeni on...", "My name is...", R.drawable.color_phrases));
        phrases.add(new Word("Missä asut?", "Where are you living?", R.drawable.color_phrases));
        phrases.add(new Word("Saanko oluen, kiitos?", "Can I have beer, please?", R.drawable.color_phrases));
        phrases.add(new Word("Kiitoksia paljon", "Thank you so much", R.drawable.color_phrases));
        phrases.add(new Word("Anteeksi", "Excuse me", R.drawable.color_phrases));
        phrases.add(new Word("Mitä mieltä olet?", "What do you think?", R.drawable.color_phrases));
        phrases.add(new Word("Minä opettelen suomen kieltä", "I'm learning Finnish", R.drawable.color_phrases));
        phrases.add(new Word("En ymmärrä", "I don't understand", R.drawable.color_phrases));
        phrases.add(new Word("Voisitko toistaa?", "Could you repeat that, please?", R.drawable.color_phrases));
        phrases.add(new Word("Kiitoksia", "Thank you", R.drawable.color_phrases));
        phrases.add(new Word("Mitä tarkoitat?", "What do you mean?", R.drawable.color_phrases));
        phrases.add(new Word("Hauska tavata", "Nice to meet you", R.drawable.color_phrases));
        phrases.add(new Word("Mistä olet kotoisin?", "Where are you from?", R.drawable.color_phrases));
        phrases.add(new Word("Mitä teet?", "What do you do?", R.drawable.color_phrases));
        phrases.add(new Word("Voinko olla avuksi?", "Can I help you?", R.drawable.color_phrases));
        phrases.add(new Word("Paljonko kello on?", "What's the time is?", R.drawable.color_phrases));


        WordAdapter adapter = new WordAdapter(this, phrases, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
