package com.smartsensesolutions.token.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.DashboardAdapter;
import com.smartsensesolutions.token.config.ConfigCommonStrings;
import com.smartsensesolutions.token.fragments.Transaction;
import com.smartsensesolutions.token.fragments.Wallet;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView actionBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initializeControls();
    }

    public void initializeControls() {
        try {
            actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            tabLayout = (TabLayout) findViewById(R.id.tabs);

            actionBack.setOnClickListener(this);

            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);

            getIntentValue();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getIntentValue() {
        try {
            if (getIntent() != null) {
                if (getIntent().hasExtra(ConfigCommonStrings.KEY_INTENT_FROM_TOKEN_SENDING)) {
                    viewPager.setCurrentItem(2);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        DashboardAdapter adapter = new DashboardAdapter(getSupportFragmentManager());
        adapter.addFragment(new Wallet(), getString(R.string.tab_wallet_title));
        adapter.addFragment(new Transaction(), getString(R.string.tab_transaction_title));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }
}
