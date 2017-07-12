package com.smartsensesolutions.token.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

public class TokenSendingDetails extends AppCompatActivity implements View.OnClickListener {

    private TextView actionBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_sending_details);

        initializeControls();
    }

    public void initializeControls() {
        try {
            actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
            actionBack.setOnClickListener(this);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }
}
