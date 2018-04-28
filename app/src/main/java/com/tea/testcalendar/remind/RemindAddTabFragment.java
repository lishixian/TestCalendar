package com.tea.testcalendar.remind;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.LinearLayout;

import com.tea.testcalendar.R;
import com.tea.testcalendar.base.VLazyFragment;

import butterknife.BindView;

/**
 * Created by lisx on 18-4-27.
 */

public class RemindAddTabFragment extends VLazyFragment<RemindAddTabPresenter> {
    private static final String TAG = RemindAddTabFragment.class.getSimpleName();

    private static final String TYPE = "remind_add_tab_type";
    private RemindType mType = RemindType.UNKNOW;

    @BindView(R.id.remind_add_fullname)
    LinearLayout mFullName;

    @BindView(R.id.remind_add_birthday)
    LinearLayout mBirthday;

    @BindView(R.id.remind_add_name)
    LinearLayout mName;

    @BindView(R.id.remind_add_time)
    LinearLayout mTime;

    @BindView(R.id.remind_add_remind)
    LinearLayout mRemind;

    @BindView(R.id.remind_add_repeat)
    LinearLayout mRepeat;

    @BindView(R.id.remind_add_remarks)
    LinearLayout mRemarks;


    public static RemindAddTabFragment newInstance() {
        return new RemindAddTabFragment();
    }

    public static RemindAddTabFragment newInstance(RemindType type, Context context) {
        RemindAddTabFragment fragment = new RemindAddTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, type.toString(context));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_remind_add_tab;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void bindUI(View rootView) {
        super.bindUI(rootView);
        mType = RemindType.getType(getContext(), getArguments().getString(TYPE));
        initView(mType);
    }

    public void initView(RemindType type) {
        switch (type) {
            case BIRTHDAY:
                initBirthDayView();
                break;
            case ANNIVERSARY:
                initAnniversaryView();
                break;
            case COUNTDOWN:
                initCountdownView();
                break;
        }

    }

    public void initBirthDayView() {
        mFullName.setVisibility(View.VISIBLE);
        mBirthday.setVisibility(View.VISIBLE);

        mName.setVisibility(View.GONE);
        mTime.setVisibility(View.GONE);
        mRepeat.setVisibility(View.GONE);
    }

    public void initAnniversaryView() {
        mFullName.setVisibility(View.GONE);
        mBirthday.setVisibility(View.GONE);

        mName.setVisibility(View.VISIBLE);
        mTime.setVisibility(View.VISIBLE);
        mRepeat.setVisibility(View.VISIBLE);
    }

    public void initCountdownView() {
        mFullName.setVisibility(View.GONE);
        mBirthday.setVisibility(View.GONE);

        mName.setVisibility(View.VISIBLE);
        mTime.setVisibility(View.VISIBLE);
        mRepeat.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public RemindAddTabPresenter newP() {
        return new RemindAddTabPresenter();
    }

    public RemindType getTabType() {
        return mType;
    }
}
