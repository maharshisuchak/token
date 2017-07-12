package com.smartsensesolutions.token.model;


import java.util.ArrayList;

public class TransactionMainPOJO {
    private ArrayList<TransactionDataPOJO> transactions;

    public ArrayList<TransactionDataPOJO> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<TransactionDataPOJO> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "ClassPojo [transactions = " + transactions + "]";
    }
}
