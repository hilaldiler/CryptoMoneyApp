package com.hilal.cryptomoneyapp.model;

public class Stats {
    private int total;
    private int offset;
    private int limit;
    private String order;
    private String base;
    private int totalMarkets;
    private int totalExchanges;
    private double totalMarketCap;
    private double total24hVolume;

    public  Stats(){

    }

    @Override
    public String toString() {
        return "Stats{" +
                "total=" + total +
                ", offset=" + offset +
                ", limit=" + limit +
                ", order='" + order + '\'' +
                ", base='" + base + '\'' +
                ", totalMarkets=" + totalMarkets +
                ", totalExchanges=" + totalExchanges +
                ", totalMarketCap=" + totalMarketCap +
                ", total24hVolume=" + total24hVolume +
                '}';
    }

    public Stats(int total, int offset, int limit, String order, String base, int totalMarkets, int totalExchanges, double totalMarketCap, double total24hVolume) {
        this.total = total;
        this.offset = offset;
        this.limit = limit;
        this.order = order;
        this.base = base;
        this.totalMarkets = totalMarkets;
        this.totalExchanges = totalExchanges;
        this.totalMarketCap = totalMarketCap;
        this.total24hVolume = total24hVolume;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getTotalMarkets() {
        return totalMarkets;
    }

    public void setTotalMarkets(int totalMarkets) {
        this.totalMarkets = totalMarkets;
    }

    public int getTotalExchanges() {
        return totalExchanges;
    }

    public void setTotalExchanges(int totalExchanges) {
        this.totalExchanges = totalExchanges;
    }

    public double getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(double totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public double getTotal24hVolume() {
        return total24hVolume;
    }

    public void setTotal24hVolume(double total24hVolume) {
        this.total24hVolume = total24hVolume;
    }
}