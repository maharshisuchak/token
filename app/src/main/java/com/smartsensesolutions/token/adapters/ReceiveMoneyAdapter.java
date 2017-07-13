package com.smartsensesolutions.token.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

import java.util.ArrayList;

public class ReceiveMoneyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> title;
    LayoutInflater inflter;

    public ReceiveMoneyAdapter(Context applicationContext, ArrayList<String> title) {
        this.context = applicationContext;
        this.title = title;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.row_spinner_receive_money, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.spinner_title);
        ImageView imageArrow = (ImageView) view.findViewById(R.id.image_arrow);
        tvTitle.setText(title.get(i));


        try {
            if (i == 0) {
                imageArrow.setVisibility(View.VISIBLE);
            } else {
                imageArrow.setVisibility(View.INVISIBLE);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}