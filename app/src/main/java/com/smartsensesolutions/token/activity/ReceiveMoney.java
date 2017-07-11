package com.smartsensesolutions.token.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.ReceiveMoneyAdapter;

import java.util.ArrayList;

public class ReceiveMoney extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerReceiveMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_money);

        initializeControls();
    }

    public void initializeControls() {
        try {
            spinnerReceiveMoney = (Spinner) findViewById(R.id.spinner_receive_money);
            spinnerReceiveMoney.setOnItemSelectedListener(this);

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

            ReceiveMoneyAdapter customAdapter = new ReceiveMoneyAdapter(getApplicationContext(), strTitle);
            spinnerReceiveMoney.setAdapter(customAdapter);
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
}
