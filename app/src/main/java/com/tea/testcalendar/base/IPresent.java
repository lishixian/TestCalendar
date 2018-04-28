package com.tea.testcalendar.base;

/**
 * Created by lisx on 2016/12/29.
 */

public interface IPresent<V> {

    void attachV(V view);

    void detachV();
}
