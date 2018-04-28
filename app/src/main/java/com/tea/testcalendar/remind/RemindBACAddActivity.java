package com.tea.testcalendar.remind;

import android.app.Fragment;
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
 * <p>
 * 提醒的"生日-纪念日-倒数日"中的添加页面
 */

public class RemindBACAddActivity extends VActivity<RemindBACAddPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.remind_bac_add_tab_layout)
    TabLayout mTableLayout;

    @BindView(R.id.remind_bac_add_view_pager)
    ViewPager mViewPager;

    private List<RemindType> mRemindTabs = new ArrayList<RemindType>() {{
        add(RemindType.BIRTHDAY);
        add(RemindType.ANNIVERSARY);
        add(RemindType.COUNTDOWN);
    }};

    @Override
    public int getLayoutId() {
        return R.layout.activity_remind_bac_add;
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
            fragmentArrays.add(RemindAddTabFragment.newInstance(type, this));
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
        mToolbar.setTitle(getResources().getString(R.string.remind_birthday));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.remind_add_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remind_search:
                return true;
            case R.id.remind_add_confirm:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public RemindBACAddPresenter newP() {
        return new RemindBACAddPresenter();
    }
}
