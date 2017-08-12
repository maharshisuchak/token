package com.smartsensesolutions.token.config;


import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigCommonClass {

    public static String getEditTextValue(EditText editText) {
        try {
            return editText.getText().toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getCurrentDate() {
        try {
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat(ConfigCommonStrings.DATE_FORMAT);
            String currentDateandTime = sdf.format(new Date());
            Log.d("Current Date", currentDateandTime);
            return currentDateandTime;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getDeviceWidth(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getDeviceHeight(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
