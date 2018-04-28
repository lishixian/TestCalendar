package com.tea.testcalendar.base;

import android.content.Context;
import android.view.View;

/**
 * Created by lisx on 18-4-19.
 */

public class VDelegateBase implements VDelegate {


    private Context context;

    private VDelegateBase(Context context) {
        this.context = context;
    }

    public static VDelegate create(Context context) {
        return new VDelegateBase(context);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void visible(boolean flag, View view) {

    }

    @Override
    public void gone(boolean flag, View view) {

    }

    @Override
    public void inVisible(View view) {

    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void toastLong(String msg) {

    }
}
