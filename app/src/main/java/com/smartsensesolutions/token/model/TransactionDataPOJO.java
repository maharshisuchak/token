package com.smartsensesolutions.token.model;


import java.util.ArrayList;

public class TransactionDataPOJO {
    private String transaction_date;

    private ArrayList<TransactionDetailPOJO> transaction_details;

    private String transaction_id;

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public ArrayList<TransactionDetailPOJO> getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(ArrayList<TransactionDetailPOJO> transaction_details) {
        this.transaction_details = transaction_details;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public String toString() {
        return "ClassPojo [transaction_date = " + transaction_date + ", transaction_details = " + transaction_details + ", transaction_id = " + transaction_id + "]";
    }
}
