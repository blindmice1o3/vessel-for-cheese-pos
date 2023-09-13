package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.List;

public class PumpkinSpiceFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = PumpkinSpiceFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "PumpkinSpiceFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Pumpkin Spice Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Pumpkin plus traditional fall spice flavors, blended with coffee, milk and ice and topped with whipped cream and pumpkin-pie spice. Think of it as the ultimate fall care package.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 65;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final Sauce.Type DEFAULT_SAUCE_PUMPKIN = Sauce.Type.PUMPKIN_SAUCE;
    public static final Topping.Type DEFAULT_TOPPING_PUMPKIN_SPICE = Topping.Type.PUMPKIN_SPICE_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public PumpkinSpiceFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Sauce saucePumpkin = new Sauce(DEFAULT_SAUCE_PUMPKIN, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                saucePumpkin, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(saucePumpkin);

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

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Topping toppingPumpkinSpice = new Topping(DEFAULT_TOPPING_PUMPKIN_SPICE, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT);

        toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                toppingPumpkinSpice, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(toppingPumpkinSpice);
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
            case VENTI_ICED:
                numberOfPumpNew = 2;
                break;
            case VENTI_HOT:
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }
}
