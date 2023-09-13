package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.List;

public class CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caramel Ribbon Crunch Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Buttery caramel syrup is blended with milk and ice, then topped with a layer of dark caramel sauce, whipped cream, caramel drizzle and a crunchy caramel-sugar topping--oh-so-beautifully delicious.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 46;
    public static final float DEFAULT_FAT_IN_GRAM = 22.0f;

    public static final Sauce.Type DEFAULT_SAUCE_DARK_CARAMEL = Sauce.Type.NEW_DARK_CARAMEL_SAUCE;
    public static final Drizzle.Type DEFAULT_DRIZZLE_CARAMEL = Drizzle.Type.CARAMEL_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_CARAMEL_AMOUNT = Granular.Amount.MEDIUM;
    public static final Topping.Type DEFAULT_TOPPING_CARAMEL_CRUNCH = Topping.Type.CARAMEL_CRUNCH_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_CARAMEL_CRUNCH_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Sauce sauceDarkCaramel = new Sauce(DEFAULT_SAUCE_DARK_CARAMEL, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                sauceDarkCaramel, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(sauceDarkCaramel);

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
        Topping toppingCaramelCrunch = new Topping(DEFAULT_TOPPING_CARAMEL_CRUNCH, DEFAULT_TOPPING_CARAMEL_CRUNCH_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                toppingCaramelCrunch, DEFAULT_TOPPING_CARAMEL_CRUNCH_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(toppingCaramelCrunch);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Drizzle drizzleCaramel = new Drizzle(DEFAULT_DRIZZLE_CARAMEL, DEFAULT_DRIZZLE_CARAMEL_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleCaramel, DEFAULT_DRIZZLE_CARAMEL_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleCaramel);
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfPumpNew = 3;
                break;
            case GRANDE:
                numberOfPumpNew = 5;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfPumpNew = 6;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }
}
