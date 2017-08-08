package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.fragments.NewDashboard;

public class Menus extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout relativeSendMoney, relativeRequestMoney, relativeDeposit, relativeWithdraw, relativeTransferWallet, relativeSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        initializeControls();

        goToFragment();
    }

    public void initializeControls() {
        relativeSendMoney = (RelativeLayout) findViewById(R.id.relativeSendMoney);
        relativeRequestMoney = (RelativeLayout) findViewById(R.id.relativeRequestMoney);
        relativeDeposit = (RelativeLayout) findViewById(R.id.relativeDeposit);
        relativeWithdraw = (RelativeLayout) findViewById(R.id.relativeWithdraw);
        relativeTransferWallet = (RelativeLayout) findViewById(R.id.relativeTransferWallet);
        relativeSettings = (RelativeLayout) findViewById(R.id.relativeSettings);

        relativeSendMoney.setOnClickListener(this);
        relativeRequestMoney.setOnClickListener(this);
        relativeDeposit.setOnClickListener(this);
        relativeWithdraw.setOnClickListener(this);
        relativeTransferWallet.setOnClickListener(this);
        relativeSettings.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relativeSendMoney:
                goTo(SendMoney.class);
                closeDrawer();
                break;
            case R.id.relativeRequestMoney:
                goTo(ReceiveMoney.class);
                closeDrawer();
                break;
            case R.id.relativeDeposit:
                Toast.makeText(this, "Deposit", Toast.LENGTH_SHORT).show();
                closeDrawer();
                break;
            case R.id.relativeWithdraw:
                Toast.makeText(this, "Withdraw", Toast.LENGTH_SHORT).show();
                closeDrawer();
                break;
            case R.id.relativeTransferWallet:
                goTo(TransferMyWallet.class);
                closeDrawer();
                break;
            case R.id.relativeSettings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                closeDrawer();
                break;
        }
    }

    public void goToFragment() {
        try {
            Fragment fragment = new NewDashboard();
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment).commit();

            } else {
                // error in creating fragment
                Log.e("MainActivity", "Error in creating fragment");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(Menus.this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeDrawer() {
        try {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
