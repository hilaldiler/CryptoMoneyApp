package com.hilal.cryptomoneyapp.model;

public class Base {

    private String symbol;
    private String sign;

    public Base(String symbol, String sign) {
        this.symbol = symbol;
        this.sign = sign;
    }

    public Base() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
