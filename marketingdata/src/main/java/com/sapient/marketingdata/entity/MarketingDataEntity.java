package com.sapient.marketingdata.entity;

public class MarketingDataEntity {
    Integer id;

    String name;
    String identifier;
    double price;
    boolean isPositive;

    public MarketingDataEntity() {
        super();
    }

    public MarketingDataEntity(String name, String identifier, double price, boolean isPositive) {
        super();
        this.name = name;
        this.identifier = identifier;
        this.price = price;
        this.isPositive = isPositive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean isPositive) {
        this.isPositive = isPositive;
    }


    @Override
    public String toString() {
        return "MarketDataEntity [name=" + name + ", identifier=" + identifier + ", price=" + price + "]";
    }

}
