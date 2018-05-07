package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.color_red, "weṭeṭṭi", "red", R.raw.color_red));
        words.add(new Word(R.drawable.color_green, "chokokki", "green", R.raw.color_green));
        words.add(new Word(R.drawable.color_brown, "ṭakaakki", "brown", R.raw.color_brown));
        words.add(new Word(R.drawable.color_gray, "ṭopoppi", "gray", R.raw.color_gray));
        words.add(new Word(R.drawable.color_black, "kululli", "black", R.raw.color_black));
        words.add(new Word(R.drawable.color_white, "kelelli", "white", R.raw.color_white));
        words.add(new Word(R.drawable.color_dusty_yellow, "ṭopiisә", "dusty yellow", R.raw.color_dusty_yellow));
        words.add(new Word(R.drawable.color_mustard_yellow, "chiwiiṭә", "mustard yellow", R.raw.color_mustard_yellow));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudio());
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}