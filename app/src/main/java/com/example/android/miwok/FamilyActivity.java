package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.family_father, "әpә", "father"));
        words.add(new Word(R.drawable.family_mother, "әṭa", "mother"));
        words.add(new Word(R.drawable.family_son, "angsi", "son"));
        words.add(new Word(R.drawable.family_daughter, "tune", "daughter"));
        words.add(new Word(R.drawable.family_older_brother, "taachi", "older brother"));
        words.add(new Word(R.drawable.family_younger_brother, "chalitti", "younger brother"));
        words.add(new Word(R.drawable.family_older_sister, "teṭe", "older sister"));
        words.add(new Word(R.drawable.family_younger_sister, "kolliti", "younger sister"));
        words.add(new Word(R.drawable.family_grandmother, "ama", "grandmother"));
        words.add(new Word(R.drawable.family_grandfather, "paapa", "grandfather"));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
