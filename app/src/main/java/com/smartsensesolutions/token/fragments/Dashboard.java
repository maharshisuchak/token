package com.smartsensesolutions.token.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.adapters.DashboardAdapter;

public class Dashboard extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initializeControls(rootView);

        return rootView;
    }

    public void initializeControls(View rootView) {
        try {
            viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
            tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        DashboardAdapter adapter = new DashboardAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new Wallet(), getString(R.string.tab_wallet_title));
        adapter.addFragment(new Transaction(), getString(R.string.tab_transaction_title));
        viewPager.setAdapter(adapter);
    }
}
