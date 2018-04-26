package com.tea.testcalendar;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by le on 2018/4/26.
 */

public class RemindFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.fragment_remind);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ListView lv = (ListView)view.findViewById(android.R.id.list);
        lv.setBackgroundColor(R.color.ghostwhite);

        return view;
    }
}
