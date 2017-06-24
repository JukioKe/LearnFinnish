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

        familyWords.add(new Word("perhe", "family", R.drawable.family_family));
        familyWords.add(new Word("isä", "father", R.drawable.family_father));
        familyWords.add(new Word("äiti", "mother", R.drawable.family_mother));
        familyWords.add(new Word("poika", "son", R.drawable.family_son));
        familyWords.add(new Word("tytär", "daughter", R.drawable.family_daughter));
        familyWords.add(new Word("veli", "brother", R.drawable.family_son));
        familyWords.add(new Word("isoveli", "big brother", R.drawable.family_older_brother));
        familyWords.add(new Word("pikkuveli", "younger brother", R.drawable.family_son));
        familyWords.add(new Word("isosisko", "older sister", R.drawable.family_older_sister));
        familyWords.add(new Word("pikkusisko", "younger sister", R.drawable.family_daughter));
        familyWords.add(new Word("isoäiti", "grandmother", R.drawable.family_grandmother));
        familyWords.add(new Word("isoisä", "grandfather", R.drawable.family_grandfather));
        familyWords.add(new Word("lapsenlapsi", "grandchild", R.drawable.family_baby));
        familyWords.add(new Word("setä", "uncle", R.drawable.family_uncle));
        familyWords.add(new Word("täti", "aunt", R.drawable.family_aunt));
        familyWords.add(new Word("vanhemmat", "parents", R.drawable.family_parents));
        familyWords.add(new Word("lapsi", "child", R.drawable.family_daughter));
        familyWords.add(new Word("veljenpoika", "nephew", R.drawable.family_son));
        familyWords.add(new Word("veljentytär", "niece", R.drawable.family_daughter));
        familyWords.add(new Word("serkku", "cousin", R.drawable.family_cousin));
        familyWords.add(new Word("aviomies", "husband", R.drawable.family_husband));
        familyWords.add(new Word("vaimo", "wife", R.drawable.family_wife));
        familyWords.add(new Word("kummisetä", "godfather", R.drawable.family_godfather));
        familyWords.add(new Word("vauva", "baby", R.drawable.family_baby));
        familyWords.add(new Word("sukulainen", "relative", R.drawable.family_relative));


        WordAdapter adapter = new WordAdapter(this, familyWords, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.word_list);

        if (listView != null) {
            listView.setAdapter(adapter);
        }


    }
}
