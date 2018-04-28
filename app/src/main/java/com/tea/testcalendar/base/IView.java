package com.tea.testcalendar.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by lisx on 2016/12/29.
 */

public interface IView<P> {

    void bindUI(View rootView);

    int getLayoutId();

    void initData(Bundle savedInstanceState);

    int getOptionsMenuId();

    P newP();
}
