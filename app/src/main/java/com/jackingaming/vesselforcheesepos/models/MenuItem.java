package com.jackingaming.vesselforcheesepos.models;

public abstract class MenuItem {
    protected String name;
    protected String description;
    protected double price;
    protected boolean handedOff;

    public MenuItem() {
    }

    public MenuItem(String name, String description, double price, boolean handedOff) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.handedOff = handedOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHandedOff() {
        return handedOff;
    }

    public void setHandedOff(boolean handedOff) {
        this.handedOff = handedOff;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", handedOff=" + handedOff +
                '}';
    }
}
