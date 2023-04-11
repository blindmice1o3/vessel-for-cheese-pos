package com.jackingaming.vesselforcheesepos.models.menu;

public abstract class MenuItem {
    public static final boolean HANDED_OFF_DEFAULT = false;

    protected long id;
    protected String name;
    protected String description;
    protected double price;
    protected boolean handedOff;

    public MenuItem() {
    }

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.handedOff = HANDED_OFF_DEFAULT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
