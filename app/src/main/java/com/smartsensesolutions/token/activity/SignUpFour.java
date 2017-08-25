package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

public class SignUpFour extends AppCompatActivity implements View.OnClickListener {

    private TextView txtContinue, txtBottomBack;
    private ImageView imageIndicatorThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_four);
        initializeControls();
    }

    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_sign_up_continue);
        imageIndicatorThree = (ImageView) findViewById(R.id.img_indicator_three);
        imageIndicatorThree.setImageResource(R.drawable.ic_grey_selected_dot);
        txtBottomBack = (TextView) findViewById(R.id.txt_bottom_back);
        txtBottomBack.setVisibility(View.VISIBLE);
        txtContinue.setOnClickListener(this);
        txtBottomBack.setOnClickListener(this);
    }

    public void customBackPressed(View view) {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_sign_up_continue:
                goTo(SignUpFive.class);
                break;
            case R.id.txt_bottom_back:
                onBackPressed();
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SignUpFour.this, targetClass);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}