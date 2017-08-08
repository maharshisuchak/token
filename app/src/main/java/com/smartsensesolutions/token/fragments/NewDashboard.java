package com.smartsensesolutions.token.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.activity.Dashboard;
import com.smartsensesolutions.token.activity.Menus;

public class NewDashboard extends Fragment implements View.OnClickListener {

    private LinearLayout linearBCSpending, linearBCSavings, linearLCSpending, linearLCSavings;
    private TextView text_bc_spending_money, text_bc_savings_money, text_lc_spending_money, text_lc_savings_money;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_dashboard, container, false);

        initializeControls(rootView);

        return rootView;
    }

    public void initializeControls(View rootView) {
        linearBCSpending = (LinearLayout) rootView.findViewById(R.id.linear_bc_spending);
        linearBCSavings = (LinearLayout) rootView.findViewById(R.id.linear_bc_savings);
        linearLCSpending = (LinearLayout) rootView.findViewById(R.id.linear_lc_spending);
        linearLCSavings = (LinearLayout) rootView.findViewById(R.id.linear_lc_savings);
        text_bc_spending_money = (TextView) rootView.findViewById(R.id.text_bc_spending_money);
        text_bc_savings_money = (TextView) rootView.findViewById(R.id.text_bc_savings_money);
        text_lc_spending_money = (TextView) rootView.findViewById(R.id.text_lc_spending_money);
        text_lc_savings_money = (TextView) rootView.findViewById(R.id.text_lc_savings_money);

        linearBCSpending.setOnClickListener(this);
        linearBCSavings.setOnClickListener(this);
        linearLCSpending.setOnClickListener(this);
        linearLCSavings.setOnClickListener(this);

        text_bc_spending_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_bc_savings_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_lc_spending_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_lc_savings_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_bc_spending:
                goTo(Dashboard.class);
                break;
            case R.id.linear_bc_savings:
                goTo(Dashboard.class);
                break;
            case R.id.linear_lc_spending:
                goTo(Dashboard.class);
                break;
            case R.id.linear_lc_savings:
                goTo(Dashboard.class);
                break;
        }
    }
}
