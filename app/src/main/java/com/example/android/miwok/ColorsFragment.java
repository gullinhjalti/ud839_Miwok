package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (mMediaPlayer != null) {
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
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    });

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.drawable.color_red, "weṭeṭṭi", "red", R.raw.color_red));
        words.add(new Word(R.drawable.color_green, "chokokki", "green", R.raw.color_green));
        words.add(new Word(R.drawable.color_brown, "ṭakaakki", "brown", R.raw.color_brown));
        words.add(new Word(R.drawable.color_gray, "ṭopoppi", "gray", R.raw.color_gray));
        words.add(new Word(R.drawable.color_black, "kululli", "black", R.raw.color_black));
        words.add(new Word(R.drawable.color_white, "kelelli", "white", R.raw.color_white));
        words.add(new Word(R.drawable.color_dusty_yellow, "ṭopiisә", "dusty yellow", R.raw.color_dusty_yellow));
        words.add(new Word(R.drawable.color_mustard_yellow, "chiwiiṭә", "mustard yellow", R.raw.color_mustard_yellow));
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudio());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
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
