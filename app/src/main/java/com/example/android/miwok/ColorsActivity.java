package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.color_red, "weṭeṭṭi", "red"));
        words.add(new Word(R.drawable.color_green, "chokokki", "green"));
        words.add(new Word(R.drawable.color_brown, "ṭakaakki", "brown"));
        words.add(new Word(R.drawable.color_gray, "ṭopoppi", "gray"));
        words.add(new Word(R.drawable.color_black, "kululli", "black"));
        words.add(new Word(R.drawable.color_white, "kelelli", "white"));
        words.add(new Word(R.drawable.color_dusty_yellow, "ṭopiisә", "dusty yellow"));
        words.add(new Word(R.drawable.color_mustard_yellow, "chiwiiṭә", "mustard yellow"));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
