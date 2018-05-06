package com.example.android.miwok;

public class Word {
    private String mMiwok;
    private String mDefault;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mIllustration = NO_IMAGE_PROVIDED;

    Word(String sMiwok, String sDefault) {
        mMiwok = sMiwok;
        mDefault = sDefault;
    }

    Word(int sIllustration, String sMiwok, String sDefault) {
        mIllustration = sIllustration;
        mMiwok = sMiwok;
        mDefault = sDefault;
    }

    public boolean hasIllustration() {
        return mIllustration != NO_IMAGE_PROVIDED;
    }

    public int getIllustration() {
        return mIllustration;
    }

    public String getMiwokTranslation() {
        return mMiwok;
    }

    public String getDefaultTranslation() {
        return mDefault;
    }
}
