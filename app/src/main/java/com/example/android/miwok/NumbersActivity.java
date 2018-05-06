package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.number_one, "lutti", "one"));
        words.add(new Word(R.drawable.number_two, "otiiko", "two"));
        words.add(new Word(R.drawable.number_three, "tolookosu", "three"));
        words.add(new Word(R.drawable.number_four, "oyyisa", "four"));
        words.add(new Word(R.drawable.number_five, "massokka", "five"));
        words.add(new Word(R.drawable.number_six, "temmokka", "six"));
        words.add(new Word(R.drawable.number_seven, "kenekaku", "seven"));
        words.add(new Word(R.drawable.number_eight, "kawinta", "eight"));
        words.add(new Word(R.drawable.number_nine, "wo'e", "nine"));
        words.add(new Word(R.drawable.number_ten, "na'aacha", "ten"));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
