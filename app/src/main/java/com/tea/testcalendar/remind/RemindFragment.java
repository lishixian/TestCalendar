package com.tea.testcalendar.remind;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tea.testcalendar.R;

/**
 * Created by le on 2018/4/26.
 */

public class RemindFragment extends PreferenceFragment {


    public static RemindFragment newInstance() {
        return new RemindFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.fragment_remind);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ListView lv = view.findViewById(android.R.id.list);
        //view.setBackgroundColor(Color.GRAY);
        lv.setBackgroundColor(Color.WHITE);
        return view;
    }
}
