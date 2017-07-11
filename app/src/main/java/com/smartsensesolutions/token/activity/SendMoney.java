package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.SendFromAdapter;

import java.util.ArrayList;

public class SendMoney extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner spinnerSendFrom;
    private TextView txtTransferBetweenWallet, txtManually;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        initializeControls();
    }

    public void initializeControls() {
        try {
            spinnerSendFrom = (Spinner) findViewById(R.id.spinner_send_from);
            txtTransferBetweenWallet = (TextView) findViewById(R.id.txt_transfer);
            txtManually = (TextView) findViewById(R.id.txt_manually);

            spinnerSendFrom.setOnItemSelectedListener(this);
            txtTransferBetweenWallet.setOnClickListener(this);
            txtManually.setOnClickListener(this);

            setSpinnerValue();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSpinnerValue() {
        try {
            // Spinner Drop down elements
            ArrayList<String> strTitle = new ArrayList<String>();
            strTitle.add("Automobile");
            strTitle.add("Business Services");
            strTitle.add("Computers");
            strTitle.add("Education");
            strTitle.add("Personal");
            strTitle.add("Travel");

            ArrayList<String> strValue = new ArrayList<String>();
            strValue.add("356");
            strValue.add("356");
            strValue.add("356");
            strValue.add("356");
            strValue.add("356");
            strValue.add("356");

            SendFromAdapter customAdapter = new SendFromAdapter(getApplicationContext(), strTitle, strValue);
            spinnerSendFrom.setAdapter(customAdapter);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_transfer:
                goTo(TransferMyWallet.class);
                break;
            case R.id.txt_manually:
                goTo(EnterAmount.class);
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SendMoney.this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
