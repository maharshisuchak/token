package com.smartsensesolutions.token.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.activity.NewTransactionActivity;
import com.smartsensesolutions.token.activity.ReceiveMoney;
import com.smartsensesolutions.token.activity.SendMoney;
import com.smartsensesolutions.token.adapters.WalletAdapter;
import com.smartsensesolutions.token.model.WalletPOJO;
import com.smartsensesolutions.token.utils.RecyclerItemClickListener;

import java.util.ArrayList;

public class NewDashboard extends Fragment implements View.OnClickListener {

    private LinearLayout linearSend, linearRequest, linearDeposit, linearWithdraw;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<WalletPOJO> walletList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WalletAdapter mAdapter;

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


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_wallets);

        mAdapter = new WalletAdapter(walletList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.clearFocus();

        prepareWalletData();

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);

        linearSend = (LinearLayout) rootView.findViewById(R.id.linearSend);
        linearRequest = (LinearLayout) rootView.findViewById(R.id.linearRequest);
        linearDeposit = (LinearLayout) rootView.findViewById(R.id.linearDeposit);
        linearWithdraw = (LinearLayout) rootView.findViewById(R.id.linearWithdraw);

        linearSend.setOnClickListener(this);
        linearRequest.setOnClickListener(this);
        linearDeposit.setOnClickListener(this);
        linearWithdraw.setOnClickListener(this);

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


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goTo(NewTransactionActivity.class);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            // Released
                            goTo(NewTransactionActivity.class);
                        }
                        return true;
                    }
                });
            }
        }));

    }

    public void prepareWalletData() {
        try {
            WalletPOJO wallet = new WalletPOJO(getResources().getString(R.string.bc_spending));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.bc_savings));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.lc_spending));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.lc_savings));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.bc_spending));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.bc_savings));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.lc_spending));
            walletList.add(wallet);

            wallet = new WalletPOJO(getResources().getString(R.string.lc_savings));
            walletList.add(wallet);

            mAdapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(getActivity(), targetClass);
            startActivity(intent);
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
}
