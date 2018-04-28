package com.tea.testcalendar.remind;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

    private static final String TYPE = "remind_tab_type";
    private RemindType mType;

    @BindView(R.id.remind_tab_recycler)
    RecyclerView mRecyclerView;

    public static RemindTabFragment newInstance() {
        return new RemindTabFragment();
    }

    public static RemindTabFragment newInstance(RemindType type, Context context) {
        RemindTabFragment fragment = new RemindTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, type.toString(context));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_remind_tab;
    }

    @Override
    public void bindUI(View rootView) {
        super.bindUI(rootView);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData(Bundle savedInstanceState) {
        mType = RemindType.getType(getContext(), getArguments().getString(TYPE));
    }

    public RemindType getTabType() {
        return mType;
    }

    @Override
    public RemindTabPresenter newP() {
        return new RemindTabPresenter();
    }
}
