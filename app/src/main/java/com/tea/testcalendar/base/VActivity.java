package com.tea.testcalendar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.tea.testcalendar.utils.KnifeKit;

import butterknife.Unbinder;


/**
 * Created by lisx on 18-3-16.
 */

public abstract class VActivity<P extends IPresent> extends AppCompatActivity
        implements IView<P> {

    private Unbinder unbinder;

    private VDelegate vDelegate;

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(null);
        }

        initData(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getOptionsMenuId() > 0) {
            getMenuInflater().inflate(getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(this);
        }
        return vDelegate;
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
    protected void onDestroy() {
        super.onDestroy();

        if (getP() != null) {
            getP().detachV();
        }

        KnifeKit.unbind(unbinder);
        getvDelegate().destory();
        mPresenter = null;
        vDelegate = null;
    }


}
