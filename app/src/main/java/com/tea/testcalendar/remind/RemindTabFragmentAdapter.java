package com.tea.testcalendar.remind;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lisx on 18-4-27.
 */
public class RemindTabFragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList;
    private final List<String> mTabTitle;

    public RemindTabFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabTitle) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle.get(position % mTabTitle.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}