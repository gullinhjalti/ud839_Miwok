package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                //Log.v("ColorActivity","AudioManager.AUDIOFOCUS_LOSS_TRANSIENT");
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mMediaPlayer.stop();
                releaseMediaPlayer();
                //Log.v("ColorActivity","AudioManager.AUDIOFOCUS_LOSS");
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                //Log.v("ColorActivity","AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //Log.v("ColorActivity","AudioManager.AUDIOFOCUS_GAIN");
                mMediaPlayer.start();
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.family_father, "әpә", "father", R.raw.family_father));
        words.add(new Word(R.drawable.family_mother, "әṭa", "mother", R.raw.family_mother));
        words.add(new Word(R.drawable.family_son, "angsi", "son", R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter, "tune", "daughter", R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother, "taachi", "older brother", R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother, "chalitti", "younger brother", R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister, "teṭe", "older sister", R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister, "kolliti", "younger sister", R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother, "ama", "grandmother", R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather, "paapa", "grandfather", R.raw.family_grandfather));
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudio());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
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
            mAudioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
