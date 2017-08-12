package com.smartsensesolutions.token.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.activity.ReceiveMoney;
import com.smartsensesolutions.token.activity.SendMoney;
import com.smartsensesolutions.token.config.ConfigCommonClass;

public class Wallet extends Fragment implements View.OnClickListener {

    private TextView txtSendMoney, txtRequestMoney;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ScrollView scrollView;
    private RelativeLayout relativeFragmentWallet;


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
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);
        scrollView = (ScrollView) rootView.findViewById(R.id.scrollFooterWallet);
        relativeFragmentWallet = (RelativeLayout) rootView.findViewById(R.id.relativeFragmentWallet);
        txtSendMoney.setOnClickListener(this);
        txtRequestMoney.setOnClickListener(this);


        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(getActivity(), "Refresh Wallet!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }, 3000);
                    }
                }
        );
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
