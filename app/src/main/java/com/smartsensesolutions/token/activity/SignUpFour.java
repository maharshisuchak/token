package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

public class SignUpFour extends AppCompatActivity  implements View.OnClickListener {

    private TextView txtContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_four);
        initializeControls();
    }

    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_sign_up_continue);
        txtContinue.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_sign_up_continue:
                goTo(SignUpFive.class);
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SignUpFour.this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}