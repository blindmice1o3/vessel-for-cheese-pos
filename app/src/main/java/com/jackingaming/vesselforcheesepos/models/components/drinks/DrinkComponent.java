package com.jackingaming.vesselforcheesepos.models.components.drinks;

public abstract class DrinkComponent {
    protected boolean customization;

    public DrinkComponent() {
    }

    public DrinkComponent(boolean customization) {
        this.customization = customization;
    }

    public boolean isCustomization() {
        return customization;
    }

    public void setCustomization(boolean customization) {
        this.customization = customization;
    }
}
