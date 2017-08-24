package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

public class SignUpSix extends AppCompatActivity implements View.OnClickListener {

    private TextView txtContinue,actionBack;
    private ImageView imageIndicatorFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_six);
        initializeControls();
    }

    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_sign_up_continue);
        imageIndicatorFive = (ImageView) findViewById(R.id.img_indicator_five);
        imageIndicatorFive.setImageResource(R.drawable.ic_grey_selected_dot);
        actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
        txtContinue.setBackground(getResources().getDrawable(R.drawable.continue_orange_border));
        txtContinue.setOnClickListener(this);
        actionBack.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_sign_up_continue:
                goTo(Menus.class);
                break;
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SignUpSix.this, targetClass);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}