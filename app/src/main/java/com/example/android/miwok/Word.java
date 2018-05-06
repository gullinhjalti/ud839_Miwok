package com.example.android.miwok;

public class Word {
    private String mMiwok;
    private String mDefault;

    public Word(String sMiwok, String sDefault) {
        mMiwok = sMiwok;
        mDefault = sDefault;
    }

    public String getMiwokTranslation() {
        return mMiwok;
    }

    public String getDefaultTranslation() {
        return mDefault;
    }
}
