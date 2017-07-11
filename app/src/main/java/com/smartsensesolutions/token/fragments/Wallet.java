package com.smartsensesolutions.token.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.activity.ReceiveMoney;
import com.smartsensesolutions.token.activity.SendMoney;

public class Wallet extends Fragment implements View.OnClickListener {

    private TextView txtSendMoney, txtRequestMoney;


    public Wallet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);

        initializeControls(rootView);

        return rootView;
    }

    public void initializeControls(View rootView) {
        txtSendMoney = (TextView) rootView.findViewById(R.id.txt_wallet_send_money);
        txtRequestMoney = (TextView) rootView.findViewById(R.id.txt_wallet_request_money);
        txtSendMoney.setOnClickListener(this);
        txtRequestMoney.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_wallet_send_money:
                goTo(SendMoney.class);
                break;
            case R.id.txt_wallet_request_money:
                goTo(ReceiveMoney.class);
                break;
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(getActivity(), targetClass);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
