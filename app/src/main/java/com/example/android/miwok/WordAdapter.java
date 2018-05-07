package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mBgColor;

    WordAdapter(Activity context, ArrayList<Word> words, int bgColor) {
        super(context, 0, words);
        mBgColor = bgColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = getItem(position);
        if (currentWord != null) {
            ImageView illustrativeImage = listItemView.findViewById(R.id.illustrative_image);
            if (currentWord.hasIllustration()) {
                illustrativeImage.setVisibility(View.VISIBLE);
                illustrativeImage.setImageResource(currentWord.getIllustration());
            } else {
                illustrativeImage.setVisibility(View.GONE);
            }
            TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
            miwokTextView.setText(currentWord.getMiwokTranslation());
            miwokTextView.setBackgroundResource(mBgColor);
            TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
            defaultTextView.setText(currentWord.getDefaultTranslation());
            defaultTextView.setBackgroundResource(mBgColor);
        }
        return listItemView;
    }
}
