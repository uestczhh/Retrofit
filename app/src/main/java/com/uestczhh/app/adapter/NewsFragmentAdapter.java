package com.uestczhh.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 新闻类型fragment适配器
 * Created by zhanghao on 2016/9/26.
 */
public class NewsFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment;

    public NewsFragmentAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
