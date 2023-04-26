package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class AddInsOptions extends DrinkComponent {
    public static final String TAG = AddInsOptions.class.getSimpleName();

    public enum LineTheCup {
        NONE,
        CARAMEL_SAUCE,
        MOCHA_SAUCE;
    }

    public enum MilkCreamer {
        TWO_PERCENT,
        BREVE,
        COCONUT,
        HEAVY_CREAM,
        NONFAT_MILK,
        OATMILK,
        SOY,
        VANILLA_SWEET_CREAM,
        WHOLE_MILK,
        ALMOND;
    }

    public enum Room {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    public enum Powder {
        CHOCOLATE_MALT,
        VANILLA_BEAN;
    }

    public enum Water {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    public enum Ice {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    // TODO: NONE, LIGHT, MEDIUM, EXTRA; (but only for STRAWBERRY_PUREE)
    public enum Fruit {
        DRAGONFRUIT_INCLUSION,
        PINEAPPLE_INCLUSION,
        STRAWBERRY_INCLUSION,
        STRAWBERRY_PUREE;
    }

    private LineTheCup lineTheCup;
    private MilkCreamer milkCreamer;
    private Room room;
    private Powder powder;
    private Water water;
    private Ice ice;
    private Fruit fruit;

    public AddInsOptions(LineTheCup lineTheCup) {
        this.lineTheCup = lineTheCup;
    }

    public AddInsOptions(MilkCreamer milkCreamer) {
        this.milkCreamer = milkCreamer;
    }

    public AddInsOptions(Room room) {
        this.room = room;
    }

    public AddInsOptions(Powder powder) {
        this.powder = powder;
    }

    public AddInsOptions(Water water) {
        this.water = water;
    }

    public AddInsOptions(Ice ice) {
        this.ice = ice;
    }

    public AddInsOptions(Fruit fruit) {
        this.fruit = fruit;
    }

    public LineTheCup getLineTheCup() {
        return lineTheCup;
    }

    public MilkCreamer getMilkCreamer() {
        return milkCreamer;
    }

    public Room getRoom() {
        return room;
    }

    public Powder getPowder() {
        return powder;
    }

    public Water getWater() {
        return water;
    }

    public Ice getIce() {
        return ice;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @NonNull
    @Override
    public String toString() {
        String nameAddInsOptions = null;
        if (lineTheCup != null) {
            nameAddInsOptions = LineTheCup.class.getSimpleName() + ": " + lineTheCup.name();
        } else if (milkCreamer != null) {
            nameAddInsOptions = MilkCreamer.class.getSimpleName() + ": " + milkCreamer.name();
        } else if (room != null) {
            nameAddInsOptions = Room.class.getSimpleName() + ": " + room.name();
        } else if (powder != null) {
            nameAddInsOptions = Powder.class.getSimpleName() + ": " + powder.name();
        } else if (water != null) {
            nameAddInsOptions = Water.class.getSimpleName() + ": " + water.name();
        } else if (ice != null) {
            nameAddInsOptions = Ice.class.getSimpleName() + ": " + ice.name();
        } else if (fruit != null) {
            nameAddInsOptions = Fruit.class.getSimpleName() + ": " + fruit.name();
        } else {
            String errorMessage = AddInsOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameAddInsOptions = errorMessage;
        }
        return nameAddInsOptions;
    }
}
