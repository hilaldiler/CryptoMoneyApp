package com.hilal.cryptomoneyapp.model;

public class Coins {

    private int id;
    private String symbol;
    private String name;
    private String color;
    private String vector;
    private String type;
    private String iconType;
    private String iconUrl;
    private Boolean confirmedSupply;
    private double price;
    private Boolean description;
    private int numberOfMarkets;
    private int numberOfExchanges;
    private double firstSeen;
    private float change;
    private float rank;
    private double volume;


    @Override
    public String toString() {
        return "Coins{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", vector='" + vector + '\'' +
                ", type='" + type + '\'' +
                ", iconType='" + iconType + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", confirmedSupply=" + confirmedSupply +
                ", price=" + price +
                ", description=" + description +
                ", numberOfMarkets=" + numberOfMarkets +
                ", numberOfExchanges=" + numberOfExchanges +
                ", firstSeen=" + firstSeen +
                ", change=" + change +
                ", rank=" + rank +
                ", volume=" + volume +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Boolean getConfirmedSupply() {
        return confirmedSupply;
    }

    public void setConfirmedSupply(Boolean confirmedSupply) {
        this.confirmedSupply = confirmedSupply;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(Boolean description) {
        this.description = description;
    }

    public int getNumberOfMarkets() {
        return numberOfMarkets;
    }

    public void setNumberOfMarkets(int numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
    }

    public int getNumberOfExchanges() {
        return numberOfExchanges;
    }

    public void setNumberOfExchanges(int numberOfExchanges) {
        this.numberOfExchanges = numberOfExchanges;
    }

    public double getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(double firstSeen) {
        this.firstSeen = firstSeen;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

