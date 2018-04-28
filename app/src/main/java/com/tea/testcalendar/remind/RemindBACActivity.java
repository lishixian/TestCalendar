package com.tea.testcalendar.remind;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tea.testcalendar.R;
import com.tea.testcalendar.base.VActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lisx on 18-4-27.
 */
public class RemindBACActivity extends VActivity<RemindBACPresenter> {

    private static final String TAG = RemindBACActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.remind_bac_tab_layout)
    TabLayout mTableLayout;

    @BindView(R.id.remind_bac_tab_view_pager)
    ViewPager mViewPager;

    private List<Fragment> mFragmentArrays = new ArrayList<>();
    private List<String> mTabs = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_remind_bac;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTableLayout.removeAllTabs();
        mViewPager.removeAllViews();

        initTabs();

    }

    private void initTabs() {
        if (mFragmentArrays != null) {
            mFragmentArrays.clear();
            mTabs.clear();
        }

        mTabs.add(getResources().getString(R.string.remind_all));
        mTabs.add(getResources().getString(R.string.remind_birthday));
        mTabs.add(getResources().getString(R.string.remind_anniversary));
        mTabs.add(getResources().getString(R.string.remind_countdown));

        for (int i = 0; i < mTabs.size(); i++) {
            mFragmentArrays.add(new RemindTabFragment());
        }

        mViewPager.setAdapter(new RemindTabFragmentAdapter(getFragmentManager(), mFragmentArrays, mTabs));
        mTableLayout.setupWithViewPager(mViewPager);

        mToolbar.setTitle(getResources().getString(R.string.remind_all));
        mTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mToolbar.setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public RemindBACPresenter newP() {
        return new RemindBACPresenter();
    }
}