package com.example.android.miwok;

public class Word {
    private String mMiwok;
    private String mDefault;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mIllustration = NO_IMAGE_PROVIDED;
    private int mAudio;

    Word(String sMiwok, String sDefault, int sAudio) {
        mMiwok = sMiwok;
        mDefault = sDefault;
        mAudio = sAudio;
    }

    Word(int sIllustration, String sMiwok, String sDefault, int sAudio) {
        mIllustration = sIllustration;
        mMiwok = sMiwok;
        mDefault = sDefault;
        mAudio = sAudio;
    }

    public boolean hasIllustration() {
        return mIllustration != NO_IMAGE_PROVIDED;
    }

    public int getIllustration() {
        return mIllustration;
    }

    public int getAudio() {
        return mAudio;
    }

    public String getMiwokTranslation() {
        return mMiwok;
    }

    public String getDefaultTranslation() {
        return mDefault;
    }
}
