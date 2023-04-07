package com.jackingaming.vesselforcheesepos.models;

public abstract class Customization {
    protected String name;
    protected double price;

    public Customization() {
    }

    public Customization(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customization{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
