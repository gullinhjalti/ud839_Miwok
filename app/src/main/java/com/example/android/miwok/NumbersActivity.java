package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.number_one, "lutti", "one", R.raw.number_one));
        words.add(new Word(R.drawable.number_two, "otiiko", "two", R.raw.number_two));
        words.add(new Word(R.drawable.number_three, "tolookosu", "three", R.raw.number_three));
        words.add(new Word(R.drawable.number_four, "oyyisa", "four", R.raw.number_four));
        words.add(new Word(R.drawable.number_five, "massokka", "five", R.raw.number_five));
        words.add(new Word(R.drawable.number_six, "temmokka", "six", R.raw.number_six));
        words.add(new Word(R.drawable.number_seven, "kenekaku", "seven", R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight, "kawinta", "eight", R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine, "wo'e", "nine", R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten, "na'aacha", "ten", R.raw.number_ten));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                releaseMediaPlayer(mMediaPlayer);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudio());
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer(mp);
                    }
                });

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }

    private void releaseMediaPlayer(MediaPlayer mp) {
        if (mp != null) {
            mp.release();
            mMediaPlayer = null;
        }
    }
}
