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

    }
}
