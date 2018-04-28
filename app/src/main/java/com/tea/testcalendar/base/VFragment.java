package com.tea.testcalendar.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tea.testcalendar.utils.KnifeKit;

import butterknife.Unbinder;

/**
 * Created by lisx on 18-3-19.
 */

public abstract class VFragment<P extends IPresent> extends Fragment implements IView<P> {

    private VDelegate vDelegate;

    private P mPresenter;

    protected Activity context;

    private View rootView;

    protected LayoutInflater layoutInflater;

    private Unbinder unbind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutInflater = inflater;
        if (rootView == null && getLayoutId() > 0) {
            rootView = inflater.inflate(getLayoutId(), null);
            bindUI(rootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData(savedInstanceState);
    }

    public View getRootView() {
        return rootView;
    }

    protected P getP() {
        if (mPresenter == null) {
            mPresenter = newP();
            if (mPresenter != null) {
                mPresenter.attachV(this);
            }
        }
        return mPresenter;
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public void bindUI(View rootView) {
        unbind = KnifeKit.bind(this, rootView);
    }

    protected VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(context);
        }
        return vDelegate;
    }

    protected Intent getIntent() {
        return getActivity().getIntent();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (getP() != null) {
            getP().detachV();
        }
        KnifeKit.unbind(unbind);
        getvDelegate().destory();
        mPresenter = null;
        vDelegate = null;
    }

}
