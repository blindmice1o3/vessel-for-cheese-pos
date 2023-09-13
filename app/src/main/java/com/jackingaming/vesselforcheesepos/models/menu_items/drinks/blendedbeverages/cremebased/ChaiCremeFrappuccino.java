package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.List;

public class ChaiCremeFrappuccino extends CremeBased {
    public static final String TAG = ChaiCremeFrappuccino.class.getSimpleName();

    public static final String ID = "ChaiCremeFrappuccino";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Chai Creme Frappuccino";
    public static final String DEFAULT_DESCRIPTION = "A creamy blend of spicy classic chai, milk and ice. Topped with sweetened whipped cream and a dash of cinnamon. Spice up your afternoon treat.";
    public static final int DEFAULT_CALORIES = 340;
    public static final int DEFAULT_SUGAR_IN_GRAM = 45;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final Chai.Type DEFAULT_CHAI = Chai.Type.CHAI;
    public static final CinnamonPowder.Type DEFAULT_CINNAMON_POWDER = CinnamonPowder.Type.CINNAMON_POWDER;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChaiCremeFrappuccino() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: TEA_OPTIONS: Chai
        drinkComponents.get(TeaOptions.TAG).remove(0);

        // TEA_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Chai chai = new Chai(DEFAULT_CHAI, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> teaOptions = drinkComponents.get(TeaOptions.TAG);
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                chai, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(chai);

        // REMOVAL: TOPPING_OPTIONS: WhippedCream
        WhippedCream whippedCream = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof WhippedCream) {
                whippedCream = (WhippedCream) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(whippedCream);
        drinkComponents.get(ToppingOptions.TAG).remove(3);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        WhippedCream whippedCreamDefined = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                whippedCreamDefined, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(whippedCreamDefined);

        // REMOVAL: TOPPING_OPTIONS: CinnamonPowder
        drinkComponents.get(ToppingOptions.TAG).remove(1);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        CinnamonPowder cinnamonPowder = new CinnamonPowder(DEFAULT_CINNAMON_POWDER, DEFAULT_CINNAMON_POWDER_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                cinnamonPowder, DEFAULT_CINNAMON_POWDER_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(cinnamonPowder);
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfPumpNew = 1;
                break;
            case GRANDE:
                numberOfPumpNew = 2;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfPumpNew = 2;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }
}
