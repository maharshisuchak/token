package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.config.ConfigCommonStrings;

public class TokenSendingDetails extends AppCompatActivity implements View.OnClickListener {

    private TextView actionBack, txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_sending_details);

        initializeControls();
    }

    public void initializeControls() {
        try {
            actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
            txtSend = (TextView) findViewById(R.id.txt_send);
            actionBack.setOnClickListener(this);
            txtSend.setOnClickListener(this);
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
            case R.id.txt_send:
                goTo(Menus.class);
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(TokenSendingDetails.this, targetClass);
            intent.putExtra(ConfigCommonStrings.KEY_INTENT_FROM_TOKEN_SENDING, ConfigCommonStrings.VALUE_INTENT_FROM_TOKEN_SENDING);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
