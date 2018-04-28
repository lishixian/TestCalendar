package com.tea.testcalendar.remind;

import android.content.Context;

import com.tea.testcalendar.R;

/**
 * Created by lisx on 18-4-27.
 * <p>
 * 提醒的类型
 */
public enum RemindType {
    UNKNOW(-1),
    ALL(0),
    BIRTHDAY(1),
    ANNIVERSARY(2),
    COUNTDOWN(3);
    private int type;

    RemindType(int type) {
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static RemindType getType(int num) {
        RemindType type = UNKNOW;
        switch (num) {
            case 0:
                type = ALL;
                break;
            case 1:
                type = BIRTHDAY;
                break;
            case 2:
                type = ANNIVERSARY;
                break;
            case 3:
                type = COUNTDOWN;
                break;
        }
        return type;
    }

    public static RemindType getType(Context context, String stringType) {
        RemindType type = UNKNOW;
        if (context.getString(R.string.remind_all).equals(stringType)) {
            type = ALL;
        } else if (context.getString(R.string.remind_birthday).equals(stringType)) {
            type = BIRTHDAY;
        } else if (context.getString(R.string.remind_anniversary).equals(stringType)) {
            type = ANNIVERSARY;
        } else if (context.getString(R.string.remind_countdown).equals(stringType)) {
            type = COUNTDOWN;
        }
        return type;
    }

    public String toString(Context context) {
        String str = "";
        switch (type) {
            case 0:
                str = context.getString(R.string.remind_all);
                break;
            case 1:
                str = context.getString(R.string.remind_birthday);
                break;
            case 2:
                str = context.getString(R.string.remind_anniversary);
                break;
            case 3:
                str = context.getString(R.string.remind_countdown);
                break;
        }
        return str;
    }
}
