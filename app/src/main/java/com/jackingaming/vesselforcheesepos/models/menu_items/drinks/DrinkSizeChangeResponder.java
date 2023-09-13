package com.jackingaming.vesselforcheesepos.models.menu_items.drinks;

public interface DrinkSizeChangeResponder {
    int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew);

    int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew);

    int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew);

    int getNumberOfFrapRoastByDrinkSize(DrinkSize drinkSizeNew);

    int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew);
}
