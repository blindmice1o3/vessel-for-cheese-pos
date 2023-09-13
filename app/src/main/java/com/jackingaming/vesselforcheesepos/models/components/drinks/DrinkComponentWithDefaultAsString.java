package com.jackingaming.vesselforcheesepos.models.components.drinks;

import java.io.Serializable;

public class DrinkComponentWithDefaultAsString
        implements Serializable {
    private DrinkComponent drinkComponent;
    private String drinkComponentDefaultAsString;

    public DrinkComponentWithDefaultAsString(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
        this.drinkComponent = drinkComponent;
        this.drinkComponentDefaultAsString = drinkComponentDefaultAsString;
    }

    public DrinkComponent getDrinkComponent() {
        return drinkComponent;
    }

    public void setDrinkComponent(DrinkComponent drinkComponent) {
        this.drinkComponent = drinkComponent;
    }

    public String getDrinkComponentDefaultAsString() {
        return drinkComponentDefaultAsString;
    }

    public void setDrinkComponentDefaultAsString(String drinkComponentDefaultAsString) {
        this.drinkComponentDefaultAsString = drinkComponentDefaultAsString;
    }
}
