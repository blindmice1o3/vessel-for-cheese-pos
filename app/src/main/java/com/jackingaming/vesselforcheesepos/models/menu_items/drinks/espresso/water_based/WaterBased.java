package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Room;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Water;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.Espresso;

import java.util.List;

public abstract class WaterBased extends Espresso {
    public static final String TAG = WaterBased.class.getSimpleName();

    public static final Water.Type DEFAULT_WATER = Water.Type.WATER;
    public static final Granular.Amount DEFAULT_WATER_AMOUNT = Granular.Amount.MEDIUM;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_ROOM_AMOUNT = Granular.Amount.NO;

    public WaterBased() {
    }

    public WaterBased(String id, int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        Water water = new Water(DEFAULT_WATER, DEFAULT_WATER_AMOUNT);
        MilkCreamer milkCreamer = new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT);
        Room room = new Room(null, DEFAULT_ROOM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                water, DEFAULT_WATER_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                milkCreamer, DEFAULT_MILK_CREAMER_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                room, DEFAULT_ROOM_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(water);
    }
}
