package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins;

import android.util.Log;

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

    private LineTheCup lineTheCup[] = new LineTheCup[2];
    private MilkCreamer milkCreamer;
    private Room room;
    private Powder powder;
    private Water water;
    private Ice ice;
    private Fruit fruit;

    public void addIce(Ice iceToBeAdded) {
        ice = iceToBeAdded;
    }

    public void addLineTheCup(LineTheCup lineTheCupToBeAdded) {
        switch (lineTheCupToBeAdded) {
            case NONE:
                lineTheCup[0] = null;
                lineTheCup[1] = null;
                break;
            case CARAMEL_SAUCE:
                // it's already inside
                if (lineTheCup[0] == LineTheCup.CARAMEL_SAUCE || lineTheCup[1] == LineTheCup.CARAMEL_SAUCE) {
                    Log.i(TAG, "addLineTheCup() switch()'s CARAMEL_SAUCE... first if case, already inside, do nothing");
                    // do nothing
                }
                // not inside... check space in first element
                else if (lineTheCup[0] == null) {
                    Log.i(TAG, "addLineTheCup() switch()'s CARAMEL_SAUCE... second if case, not inside and first element has space, store in first element");
                    lineTheCup[0] = LineTheCup.CARAMEL_SAUCE;
                }
                // not inside... first element has something in it... store in second element
                else {
                    Log.i(TAG, "addLineTheCup() switch()'s CARAMEL_SAUCE... else case, not inside and first element occupied, store in second element");
                    lineTheCup[1] = LineTheCup.CARAMEL_SAUCE;
                }
                break;
            case MOCHA_SAUCE:
                // it's already inside
                if (lineTheCup[0] == LineTheCup.MOCHA_SAUCE || lineTheCup[1] == LineTheCup.MOCHA_SAUCE) {
                    Log.i(TAG, "addLineTheCup() switch()'s MOCHA_SAUCE... first if case, already inside, do nothing");
                    // do nothing
                }
                // not inside... check space in first element
                else if (lineTheCup[0] == null) {
                    Log.i(TAG, "addLineTheCup() switch()'s MOCHA_SAUCE... second if case, not inside and first element has space, store in first element");
                    lineTheCup[0] = LineTheCup.MOCHA_SAUCE;
                }
                // not inside... first element has something in it... store in second element
                else {
                    Log.i(TAG, "addLineTheCup() switch()'s MOCHA_SAUCE... else case, not inside and first element occupied, store in second element");
                    lineTheCup[1] = LineTheCup.MOCHA_SAUCE;
                }
                break;
            default:
                Log.e(TAG, "addLineTheCup() switch()'s default");
                break;
        }
    }

    public LineTheCup[] getLineTheCup() {
        return lineTheCup;
    }

    public Ice getIce() {
        return ice;
    }
}
