package com.smartsensesolutions.token.adapters;


import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.model.WalletPOJO;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.MyViewHolder> {

    private ArrayList<WalletPOJO> walletList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        public TextView walletTitle, walletAmount;
        public ImageView walletImage;

        public MyViewHolder(View view) {
            super(view);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear_bc_spending);
            walletTitle = (TextView) view.findViewById(R.id.text_bc_spending_title);
            walletAmount = (TextView) view.findViewById(R.id.text_bc_spending_money);
            walletImage = (ImageView) view.findViewById(R.id.image_bc_spending);
        }
    }


    public WalletAdapter(ArrayList<WalletPOJO> walletList) {
        this.walletList = walletList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_wallets, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        WalletPOJO wallet = walletList.get(position);
        holder.walletTitle.setText(wallet.getWallet_title());

        holder.walletAmount.setText(Html.fromHtml("<small><sup>$</sup></small>" + 0 + "<small><sup>00</sup></small>"));
    }

    @Override
    public int getItemCount() {
        return walletList.size();
    }
}