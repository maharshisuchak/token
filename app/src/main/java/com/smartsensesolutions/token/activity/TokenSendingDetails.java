package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.config.ConfigCommonStrings;

public class TokenSendingDetails extends AppCompatActivity implements View.OnClickListener {

    private TextView txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_sending_details);

        initializeControls();
    }

    public void initializeControls() {
        try {
            txtSend = (TextView) findViewById(R.id.txt_send);
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
    }

    public void customBackPressed(View view) {
        onBackPressed();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_send:
                goTo(NewTransactionActivity.class);
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(TokenSendingDetails.this, targetClass);
            intent.putExtra(ConfigCommonStrings.KEY_INTENT_FROM_TOKEN_SENDING, ConfigCommonStrings.VALUE_INTENT_FROM_TOKEN_SENDING);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
