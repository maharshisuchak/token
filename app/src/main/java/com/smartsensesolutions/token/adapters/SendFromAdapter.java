package com.smartsensesolutions.token.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartsensesolutions.token.R;

import java.util.ArrayList;

public class SendFromAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> title;
    ArrayList<String> value;
    LayoutInflater inflter;

    public SendFromAdapter(Context applicationContext, ArrayList<String> title, ArrayList<String> value) {
        this.context = applicationContext;
        this.title = title;
        this.value = value;
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
        view = inflter.inflate(R.layout.row_spinner_send_from, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.spinner_title);
        TextView tvValue = (TextView) view.findViewById(R.id.spinner_value);
        tvTitle.setText(title.get(i));
        tvValue.setText(Html.fromHtml("<small><sup>$</sup></small>" + value.get(i) + "<small><sup>39</sup></small>"));
        return view;
    }
}