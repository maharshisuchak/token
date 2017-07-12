package com.smartsensesolutions.token.adapters;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.config.ConfigCommonStrings;
import com.smartsensesolutions.token.model.TransactionDetailPOJO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder> {

    private ArrayList<TransactionDetailPOJO> transactionList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView transaction_title, transaction_dollar, transaction_detail, transaction_bitcoin;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            transaction_title = (TextView) view.findViewById(R.id.txt_transaction_title);
            transaction_dollar = (TextView) view.findViewById(R.id.txt_transaction_dollar);
            transaction_detail = (TextView) view.findViewById(R.id.txt_transaction_detail);
            transaction_bitcoin = (TextView) view.findViewById(R.id.txt_transaction_bitcoin);
            imageView = (ImageView) view.findViewById(R.id.img_transaction);
        }
    }


    public TransactionsAdapter(ArrayList<TransactionDetailPOJO> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_transactions, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransactionDetailPOJO transaction = transactionList.get(position);
        holder.transaction_title.setText(transaction.getTransaction_title());
        holder.transaction_dollar.setText(transaction.getTransaction_amount());
        holder.transaction_detail.setText(transaction.getTransaction_extra());
        holder.transaction_bitcoin.setText(transaction.getTransaction_bitcoion());

        if (transaction.getTransaction_type().equals(ConfigCommonStrings.TT_RECEIVE)) {
            holder.imageView.setImageResource(R.drawable.ic_menu_request_money);
        } else if (transaction.getTransaction_type().equals(ConfigCommonStrings.TT_SENT)) {
            holder.imageView.setImageResource(R.drawable.ic_menu_send_money);
        } else if (transaction.getTransaction_type().equals(ConfigCommonStrings.TT_TRANSFERRED)) {
            holder.imageView.setImageResource(R.drawable.ic_menu_transfer);
        } else if (transaction.getTransaction_type().equals(ConfigCommonStrings.TT_WITHDRAW)) {
            holder.imageView.setImageResource(R.drawable.ic_menu_withdraw);
        } else if (transaction.getTransaction_type().equals(ConfigCommonStrings.TT_DEPOSIT)) {
            holder.imageView.setImageResource(R.drawable.ic_menu_deposit);
        }

        if (transaction.getTransaction_status().equals(ConfigCommonStrings.TS_UNCONFIRMED)) {
            holder.transaction_dollar.setTextColor(holder.transaction_dollar.getContext().getResources().getColor(R.color.yellow));
        } else if (transaction.getTransaction_status().equals(ConfigCommonStrings.TS_MINUS)) {
            holder.transaction_dollar.setTextColor(holder.transaction_dollar.getContext().getResources().getColor(R.color.red));
        } else if (transaction.getTransaction_status().equals(ConfigCommonStrings.TS_NORMAL)) {
            holder.transaction_dollar.setTextColor(holder.transaction_dollar.getContext().getResources().getColor(R.color.gray_text));
        } else if (transaction.getTransaction_status().equals(ConfigCommonStrings.TS_PLUS)) {
            holder.transaction_dollar.setTextColor(holder.transaction_dollar.getContext().getResources().getColor(R.color.green));
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}