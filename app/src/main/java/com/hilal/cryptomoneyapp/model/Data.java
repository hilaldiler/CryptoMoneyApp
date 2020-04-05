package com.hilal.cryptomoneyapp.model;

import java.util.ArrayList;

public class Data {
    private Stats stats;
    private Base base;
    ArrayList<Coins> coins;

    @Override
    public String toString() {
        return "Data{" +
                "stats=" + stats +
                ", base=" + base +
                ", coins=" + coins +
                '}';
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public ArrayList<Coins> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coins> coins) {
        this.coins = coins;
    }
}