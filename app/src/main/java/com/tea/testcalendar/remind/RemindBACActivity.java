package com.tea.testcalendar.remind;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
    private List<RemindType> mRemindTabs = new ArrayList<RemindType>() {{
        add(RemindType.ALL);
        add(RemindType.BIRTHDAY);
        add(RemindType.ANNIVERSARY);
        add(RemindType.COUNTDOWN);
    }};

    @Override
    public int getLayoutId() {
        return R.layout.activity_remind_bac;
    }

    @Override
    public void bindUI(View rootView) {
        super.bindUI(rootView);

        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(Color.RED);
        mToolbar.setNavigationIcon(R.mipmap.home_normal);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initTabs();
    }

    private void initTabs() {
        mTableLayout.removeAllTabs();
        mViewPager.removeAllViews();

        List<Fragment> fragmentArrays = new ArrayList<>();
        List<String> tabs = new ArrayList<>();
        for (RemindType type : mRemindTabs) {
            tabs.add(type.toString(this));
            fragmentArrays.add(RemindTabFragment.newInstance(type, this));
        }

        mViewPager.setAdapter(new RemindTabFragmentAdapter(getFragmentManager(), fragmentArrays, tabs));
        mTableLayout.setupWithViewPager(mViewPager);

        mTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

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
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mToolbar.setTitle(getResources().getString(R.string.remind_all));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.remind_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remind_search:
                return true;
            case R.id.remind_add:
                startActivity(new Intent(this, RemindBACAddActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public RemindBACPresenter newP() {
        return new RemindBACPresenter();
    }
}