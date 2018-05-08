package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MiwokFragmentPagerAdapter extends FragmentPagerAdapter {

    private Activity mActivity;

    MiwokFragmentPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        mActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = mActivity.getString(R.string.category_numbers);
                return title;
            case 1:
                title = mActivity.getString(R.string.category_family);
                return title;
            case 2:
                title = mActivity.getString(R.string.category_colors);
                return title;
            case 3:
                title = mActivity.getString(R.string.category_phrases);
                return title;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
