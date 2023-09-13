package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.cappuccinos;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.CappuccinoFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.HotMilkBased;

import java.util.List;

public abstract class Cappuccinos extends HotMilkBased {
    public static final String TAG = Cappuccinos.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final CappuccinoFoam.Type DEFAULT_CAPPUCCINO_FOAM = CappuccinoFoam.Type.MEDIUM;

    public Cappuccinos() {
    }

    public Cappuccinos(String id, int imageResourceId, String name, String description,
                       int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // MILK_OPTIONS (add into EXISTING DrinkComponent group)
        CappuccinoFoam cappuccinoFoamMedium = new CappuccinoFoam(DEFAULT_CAPPUCCINO_FOAM);

        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        milkOptions.add(0, new DrinkComponentWithDefaultAsString(
                cappuccinoFoamMedium, DEFAULT_CAPPUCCINO_FOAM.name()
        ));

        drinkComponentsStandardRecipe.add(cappuccinoFoamMedium);
    }
}
