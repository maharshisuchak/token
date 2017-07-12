package com.smartsensesolutions.token.model;


public class TransactionDetailPOJO {

    private String transaction_bitcoion;

    private String transaction_status;

    private String transaction_amount;

    private String transaction_type;

    private String transaction_extra;

    private String transaction_title;

    public String getTransaction_bitcoion() {
        return transaction_bitcoion;
    }

    public void setTransaction_bitcoion(String transaction_bitcoion) {
        this.transaction_bitcoion = transaction_bitcoion;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getTransaction_extra() {
        return transaction_extra;
    }

    public void setTransaction_extra(String transaction_extra) {
        this.transaction_extra = transaction_extra;
    }

    public String getTransaction_title() {
        return transaction_title;
    }

    public void setTransaction_title(String transaction_title) {
        this.transaction_title = transaction_title;
    }

    @Override
    public String toString() {
        return "ClassPojo [transaction_bitcoion = " + transaction_bitcoion + ", transaction_status = " + transaction_status + ", transaction_amount = " + transaction_amount + ", transaction_type = " + transaction_type + ", transaction_extra = " + transaction_extra + ", transaction_title = " + transaction_title + "]";
    }
}
