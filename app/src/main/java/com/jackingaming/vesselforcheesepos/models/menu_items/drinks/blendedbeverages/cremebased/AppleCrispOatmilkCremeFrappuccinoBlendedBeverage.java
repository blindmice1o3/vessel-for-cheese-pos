package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.List;

public class AppleCrispOatmilkCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = AppleCrispOatmilkCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "AppleCrispOatmilkCremeFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Apple Crisp Oatmilk Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Flavors of apple, cinnamon and brown sugar blended with oatmilk and ice. Topped with a spiced-apple drizzle and whipped cream.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 46;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_OATMILK = MilkBase.Type.OATMILK;
    public static final Syrup.Type DEFAULT_SYRUP_APPLE_BROWN_SUGAR = Syrup.Type.APPLE_BROWN_SUGAR;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Drizzle.Type DEFAULT_DRIZZLE_SPICED_APPLE = Drizzle.Type.SPICED_APPLE_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public AppleCrispOatmilkCremeFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_OATMILK);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_OATMILK.name());

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupAppleBrownSugar = new Syrup(DEFAULT_SYRUP_APPLE_BROWN_SUGAR, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupAppleBrownSugar, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(syrupAppleBrownSugar);

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
        Drizzle drizzleSpicedApple = new Drizzle(DEFAULT_DRIZZLE_SPICED_APPLE, DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleSpicedApple, DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleSpicedApple);
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
