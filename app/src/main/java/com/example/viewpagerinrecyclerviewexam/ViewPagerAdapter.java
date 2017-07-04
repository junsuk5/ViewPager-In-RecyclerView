package com.example.viewpagerinrecyclerviewexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by junsuk on 2017. 7. 4..
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mData;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
