package com.tea.testcalendar.base;

import android.os.Bundle;
import android.view.View;

import com.tea.testcalendar.utils.KnifeKit;

import butterknife.Unbinder;


/**
 * Created by lisx on 18-4-25.
 */

public abstract class VLazyFragment<P extends IPresent>
        extends LazyFragment implements IView<P> {

    private VDelegate vDelegate;
    private P p;

    private Unbinder unbinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(getRealRootView());
        }

        initData(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
    }

    public VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(context);
        }
        return vDelegate;
    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    protected void onDestoryLazy() {
        super.onDestoryLazy();

        if (getP() != null) {
            getP().detachV();
        }
        getvDelegate().destory();

        p = null;
        vDelegate = null;
    }



    @Override
    public int getOptionsMenuId() {
        return 0;
    }

}
