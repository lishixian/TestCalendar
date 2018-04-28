package com.tea.testcalendar.remind;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tea.testcalendar.R;
import com.tea.testcalendar.base.VLazyFragment;

import butterknife.BindView;

/**
 * Created by lisx on 18-4-27.
 */

public class RemindTabFragment extends VLazyFragment<RemindTabPresenter> {


    private static final String TAG = RemindTabFragment.class.getSimpleName();

    @BindView(R.id.remind_tab_recycler)
    RecyclerView mRecyclerView;

    public static RemindTabFragment newInstance() {
        return new RemindTabFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_remind_tab;
    }

    @Override
    public void bindUI(View rootView) {
        super.bindUI(rootView);
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public RemindTabPresenter newP() {
        return new RemindTabPresenter();
    }
}
