package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

public class StarbucksReserveColdBrew extends ColdBrews {
    public static final String TAG = StarbucksReserveColdBrew.class.getSimpleName();

    public static final String ID = "StarbucksReserveColdBrew";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Reserve Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Our Starbucks Reserve Cold Brew--a nuanced, smooth cup of coffee, perfect over ice--is extraordinarily uplifting in a bold form.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};


    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksReserveColdBrew() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // REMOVAL: LEMONADE_OPTIONS
        drinkComponents.remove(LemonadeOptions.TAG);

        // REMOVAL: PREPARATION_OPTIONS: PreparationMethod
        PreparationMethod preparationMethod = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof PreparationMethod) {
                preparationMethod = (PreparationMethod) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(preparationMethod);
        drinkComponents.remove(PreparationOptions.TAG);

        // REMOVAL: ESPRESSO_OPTIONS
        drinkComponents.remove(EspressoOptions.TAG);

        // REMOVAL: TEA_OPTIONS
        drinkComponents.remove(TeaOptions.TAG);

        // REMOVAL: SWEETENER_OPTIONS
        drinkComponents.remove(SweetenerOptions.TAG);

        // REMOVAL: FLAVOR_OPTIONS
        drinkComponents.remove(FlavorOptions.TAG);

        // REMOVAL: TOPPING_OPTIONS: WhippedCream, Topping, Drizzle, and CinnamonPowder
        drinkComponents.get(ToppingOptions.TAG).remove(4);
        drinkComponents.get(ToppingOptions.TAG).remove(3);
        drinkComponents.get(ToppingOptions.TAG).remove(2);
        drinkComponents.get(ToppingOptions.TAG).remove(1);

        // REMOVAL: ADD_INS_OPTIONS: MilkCreamer, Powders
        drinkComponents.get(AddInsOptions.TAG).remove(3);
        drinkComponents.get(AddInsOptions.TAG).remove(2);

        // REMOVAL: ADD_INS_OPTIONS: LineTheCup
        LineTheCup lineTheCup = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof LineTheCup) {
                lineTheCup = (LineTheCup) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(lineTheCup);
        drinkComponents.get(AddInsOptions.TAG).remove(1);
    }
}
