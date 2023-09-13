package com.jackingaming.vesselforcheesepos.models.menu_items;

import java.io.Serializable;

public abstract class MenuItem
        implements Serializable {
    public static final String TAG = MenuItem.class.getSimpleName();

    public static final boolean HANDED_OFF_DEFAULT = false;

    protected String id;
    protected int imageResourceId;
    protected String name;
    protected String description;
    protected int calories;
    protected int sugarInGram;
    protected float fatInGram;

    protected double price;
    protected boolean handedOff;

    public MenuItem() {
    }

    public MenuItem(String id, int imageResourceId, String name, String description,
                    int calories, int sugarInGram, float fatInGram,
                    double price) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.sugarInGram = sugarInGram;
        this.fatInGram = fatInGram;

        this.price = price;
        this.handedOff = HANDED_OFF_DEFAULT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSugarInGram() {
        return sugarInGram;
    }

    public void setSugarInGram(int sugarInGram) {
        this.sugarInGram = sugarInGram;
    }

    public float getFatInGram() {
        return fatInGram;
    }

    public void setFatInGram(float fatInGram) {
        this.fatInGram = fatInGram;
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
