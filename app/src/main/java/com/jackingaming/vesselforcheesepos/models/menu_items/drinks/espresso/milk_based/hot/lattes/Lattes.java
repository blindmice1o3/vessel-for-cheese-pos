package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.HotMilkBased;

import java.util.List;

public abstract class Lattes extends HotMilkBased {
    public static final String TAG = Lattes.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MILK_FOAM;
    public static final Granular.Amount DEFAULT_MILK_FOAM_AMOUNT = Granular.Amount.MEDIUM;

    public Lattes() {
    }

    public Lattes(String id, int imageResourceId, String name, String description,
                  int calories, int sugarInGram, float fatInGram,
                  double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // MILK_OPTIONS (add into EXISTING DrinkComponent group)
        MilkFoam milkFoamMedium = new MilkFoam(DEFAULT_MILK_FOAM, DEFAULT_MILK_FOAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        milkOptions.add(0, new DrinkComponentWithDefaultAsString(
                milkFoamMedium, DEFAULT_MILK_FOAM_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(milkFoamMedium);
    }
}
