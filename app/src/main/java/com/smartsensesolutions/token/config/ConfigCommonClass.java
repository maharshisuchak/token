package com.smartsensesolutions.token.config;


import android.widget.EditText;

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
}
