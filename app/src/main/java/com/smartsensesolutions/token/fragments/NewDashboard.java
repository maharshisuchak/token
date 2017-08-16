package com.smartsensesolutions.token.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.activity.Dashboard;
import com.smartsensesolutions.token.activity.ReceiveMoney;
import com.smartsensesolutions.token.activity.SendMoney;

public class NewDashboard extends Fragment implements View.OnClickListener, RippleView.OnRippleCompleteListener {

    private LinearLayout linearSend, linearRequest, linearDeposit, linearWithdraw;
    private TextView text_bc_spending_money, text_bc_savings_money, text_lc_spending_money, text_lc_savings_money;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RippleView rippleViewBCSpending, rippleViewBCSavings, rippleViewLCSpending, rippleViewLCSavings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_dashboard, container, false);

        initializeControls(rootView);

        return rootView;
    }

    public void initializeControls(View rootView) {
        rippleViewBCSpending = (RippleView) rootView.findViewById(R.id.rippleBCSpending);
        rippleViewBCSavings = (RippleView) rootView.findViewById(R.id.rippleBCSavings);
        rippleViewLCSpending = (RippleView) rootView.findViewById(R.id.rippleLCSpending);
        rippleViewLCSavings = (RippleView) rootView.findViewById(R.id.rippleLCSavings);
        text_bc_spending_money = (TextView) rootView.findViewById(R.id.text_bc_spending_money);
        text_bc_savings_money = (TextView) rootView.findViewById(R.id.text_bc_savings_money);
        text_lc_spending_money = (TextView) rootView.findViewById(R.id.text_lc_spending_money);
        text_lc_savings_money = (TextView) rootView.findViewById(R.id.text_lc_savings_money);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);

        linearSend = (LinearLayout) rootView.findViewById(R.id.linearSend);
        linearRequest = (LinearLayout) rootView.findViewById(R.id.linearRequest);
        linearDeposit = (LinearLayout) rootView.findViewById(R.id.linearDeposit);
        linearWithdraw = (LinearLayout) rootView.findViewById(R.id.linearWithdraw);

        rippleViewBCSpending.setOnRippleCompleteListener(this);
        rippleViewBCSavings.setOnRippleCompleteListener(this);
        rippleViewLCSpending.setOnRippleCompleteListener(this);
        rippleViewLCSavings.setOnRippleCompleteListener(this);

        linearSend.setOnClickListener(this);
        linearRequest.setOnClickListener(this);
        linearDeposit.setOnClickListener(this);
        linearWithdraw.setOnClickListener(this);

        text_bc_spending_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_bc_savings_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_lc_spending_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
        text_lc_savings_money.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));


        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(getActivity(), "Refresh Dashboard!", Toast.LENGTH_SHORT).show();
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menus, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_scan_barcode:
                Toast.makeText(getActivity(), "Scan Barcode!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearSend:
                goTo(SendMoney.class);
                break;
            case R.id.linearRequest:
                goTo(ReceiveMoney.class);
                break;
            case R.id.linearDeposit:
                Toast.makeText(getActivity(), "Deposit!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearWithdraw:
                Toast.makeText(getActivity(), "Withdraw!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onComplete(RippleView rippleView) {
        switch (rippleView.getId()) {
            case R.id.rippleBCSpending:
                goTo(Dashboard.class);
                break;
            case R.id.rippleBCSavings:
                goTo(Dashboard.class);
                break;
            case R.id.rippleLCSpending:
                goTo(Dashboard.class);
                break;
            case R.id.rippleLCSavings:
                goTo(Dashboard.class);
                break;
        }
    }
}
