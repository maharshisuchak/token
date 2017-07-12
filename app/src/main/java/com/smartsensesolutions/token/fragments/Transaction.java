package com.smartsensesolutions.token.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.TransactionsAdapter;
import com.smartsensesolutions.token.config.ConfigCommonClass;
import com.smartsensesolutions.token.config.ConfigCommonStrings;
import com.smartsensesolutions.token.model.TransactionDetailPOJO;
import com.smartsensesolutions.token.model.TransactionMainPOJO;

import java.util.ArrayList;

public class Transaction extends Fragment {

    private LinearLayout linear;
    private TransactionsAdapter mAdapter;
    private ArrayList<TransactionDetailPOJO> transactionList = new ArrayList<TransactionDetailPOJO>();

    public Transaction() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_transactions, container, false);

        initializeControls(rootView);

        return rootView;
    }

    public void initializeControls(View rootView) {
        linear = (LinearLayout) rootView.findViewById(R.id.linearTransaction);

        generateView();
    }

    public void generateView() {
        try {
            Gson gson = new Gson();
            TransactionMainPOJO transactions = gson.fromJson(ConfigCommonStrings.strDummyTransactionJSON, TransactionMainPOJO.class);
            for (int i = 0; i < transactions.getTransactions().size(); i++) {
                generateDynamicText(transactions.getTransactions().get(i).getTransaction_date());
                generateDynamicRecyclerView(transactions.getTransactions().get(i).getTransaction_details());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateDynamicText(String date) {
        try {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 30, 0, 0);
            TextView tvDate = new TextView(getActivity());
            if (ConfigCommonClass.getCurrentDate().equals(date)) {
                tvDate.setText(getString(R.string.today_title));
            } else {
                tvDate.setText(date);
            }
            tvDate.setLayoutParams(params);
            tvDate.setGravity(Gravity.CENTER);
            linear.addView(tvDate);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateDynamicRecyclerView(ArrayList<TransactionDetailPOJO> transactionList) {
        try {
            RecyclerView recyclerView = new RecyclerView(getActivity());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new TransactionsAdapter(transactionList);
            recyclerView.setAdapter(mAdapter);
            linear.addView(recyclerView);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
