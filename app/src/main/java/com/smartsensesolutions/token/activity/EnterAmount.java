package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

public class EnterAmount extends AppCompatActivity implements View.OnClickListener {

    private TextView txtContinue, actionBack, txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_amount);

        initializeControls();
    }

    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_continue);
        actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
        txtEmpty = (TextView) findViewById(R.id.txt_empty);
        txtEmpty.setText(getResources().getString(R.string.rn_dot));
        actionBack.setOnClickListener(this);
        txtContinue.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_continue:
                goTo(TokenSendingDetails.class);
                break;
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(EnterAmount.this, targetClass);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
