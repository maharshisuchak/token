package com.smartsensesolutions.token.model;


public class WalletPOJO {

    private String wallet_amount;

    private String wallet_image;

    private String wallet_title;

    public WalletPOJO(String title) {
        this.wallet_title = title;
    }

    public String getWallet_amount() {
        return wallet_amount;
    }

    public void setWallet_amount(String wallet_amount) {
        this.wallet_amount = wallet_amount;
    }

    public String getWallet_image() {
        return wallet_image;
    }

    public void setWallet_image(String wallet_image) {
        this.wallet_image = wallet_image;
    }

    public String getWallet_title() {
        return wallet_title;
    }

    public void setWallet_title(String wallet_title) {
        this.wallet_title = wallet_title;
    }

    @Override
    public String toString() {
        return "ClassPojo [wallet_amount = " + wallet_amount + ", wallet_image = " + wallet_image + ", wallet_title = " + wallet_title + "]";
    }
}
