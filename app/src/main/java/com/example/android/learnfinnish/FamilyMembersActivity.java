package com.example.android.learnfinnish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word("isä", "father", R.drawable.family_father));
        familyWords.add(new Word("äiti", "mother", R.drawable.family_mother));
        familyWords.add(new Word("poika", "son", R.drawable.family_son));
        familyWords.add(new Word("tytär", "daughter", R.drawable.family_daughter));
        familyWords.add(new Word("veli", "brother", R.drawable.family_son));
        familyWords.add(new Word("isoveli", "big brother", R.drawable.family_older_brother));
        familyWords.add(new Word("pikkuveli", "younger brother", R.drawable.family_son));
        familyWords.add(new Word("isosisko", "older sister", R.drawable.family_older_sister));
        familyWords.add(new Word("pikkusisko", "younger sister", R.drawable.family_daughter));
        familyWords.add(new Word("isovanhemmat", "grandparents"));
        familyWords.add(new Word("isoäiti", "grandmother", R.drawable.family_grandmother));
        familyWords.add(new Word("isoisä", "grandfather", R.drawable.family_grandfather));
        familyWords.add(new Word("lapsenlapsi", "grandchild", R.drawable.family_younger_brother));
        familyWords.add(new Word("setä", "uncle"));
        familyWords.add(new Word("täti", "aunt"));
        familyWords.add(new Word("vanhempi", "parent"));
        familyWords.add(new Word("lapsi", "child"));
        familyWords.add(new Word("veljenpoika", "nephew"));
        familyWords.add(new Word("veljentytär", "niece"));
        familyWords.add(new Word("serkku", "cousin"));
        familyWords.add(new Word("aviomies", "husband"));
        familyWords.add(new Word("vaimo", "wife"));
        familyWords.add(new Word("kummisetä", "godfather"));
        familyWords.add(new Word("vauva", "baby"));
        familyWords.add(new Word("sukulainen", "relative"));


        WordAdapter adapter = new WordAdapter(this, familyWords);

        ListView listView = (ListView) findViewById(R.id.word_list_view);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
