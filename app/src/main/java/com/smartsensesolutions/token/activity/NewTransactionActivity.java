package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.TransactionsAdapter;
import com.smartsensesolutions.token.config.ConfigCommonClass;
import com.smartsensesolutions.token.config.ConfigCommonStrings;
import com.smartsensesolutions.token.model.TransactionDetailPOJO;
import com.smartsensesolutions.token.model.TransactionMainPOJO;

import java.util.ArrayList;

public class NewTransactionActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout linearSend, linearRequest, linearDeposit, linearWithdraw;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView actionBack;
    private LinearLayout linear;
    private TransactionsAdapter mAdapter;
    private ArrayList<TransactionDetailPOJO> transactionList = new ArrayList<TransactionDetailPOJO>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        initializeControls();
    }

    public void initializeControls() {

        actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);

        linearSend = (LinearLayout) findViewById(R.id.linearSend);
        linearRequest = (LinearLayout) findViewById(R.id.linearRequest);
        linearDeposit = (LinearLayout) findViewById(R.id.linearDeposit);
        linearWithdraw = (LinearLayout) findViewById(R.id.linearWithdraw);

        linear = (LinearLayout) findViewById(R.id.linearTransaction);

        generateView();

        linearSend.setOnClickListener(this);
        linearRequest.setOnClickListener(this);
        linearDeposit.setOnClickListener(this);
        linearWithdraw.setOnClickListener(this);
        actionBack.setOnClickListener(this);

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(NewTransactionActivity.this, "Refresh Dashboard!", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
            TextView tvDate = new TextView(this);
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
            RecyclerView recyclerView = new RecyclerView(this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
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
                Toast.makeText(this, "Deposit!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearWithdraw:
                Toast.makeText(this, "Withdraw!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }

}
