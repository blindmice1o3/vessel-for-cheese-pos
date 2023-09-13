package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class PumpkinSpiceLatte extends Lattes {
    public static final String TAG = PumpkinSpiceLatte.class.getSimpleName();

    public static final String ID = "PumpkinSpiceLatte";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Pumpkin Spice Latte";
    public static final String DEFAULT_DESCRIPTION = "Our signature espresso and steamed milk with the celebrated flavor combination of pumpkin, cinnamon, nutmeg, and clove. Enjoy it topped with whipped cream and real pumpkin-pie spices.";
    public static final int DEFAULT_CALORIES = 390;
    public static final int DEFAULT_SUGAR_IN_GRAM = 50;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final Sauce.Type DEFAULT_SAUCE_PUMPKIN = Sauce.Type.PUMPKIN_SAUCE;
    public static final Topping.Type DEFAULT_TOPPING_PUMPKIN_SPICE = Topping.Type.PUMPKIN_SPICE_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public PumpkinSpiceLatte() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: ESPRESSO_OPTIONS: RoastOptions
        RoastOptions roastOptions = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof RoastOptions) {
                roastOptions = (RoastOptions) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(roastOptions);
        drinkComponents.get(EspressoOptions.TAG).remove(0);

        // ESPRESSO_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                new RoastOptionsAllowable(null), DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));

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
        drinkComponents.get(ToppingOptions.TAG).remove(4);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Topping toppingPumpkinSpice = new Topping(DEFAULT_TOPPING_PUMPKIN_SPICE, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT);
        WhippedCream whippedCreamDefined = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                toppingPumpkinSpice, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT.name()
        ));
        toppingOptions.add(1, new DrinkComponentWithDefaultAsString(
                whippedCreamDefined, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(toppingPumpkinSpice);
        drinkComponentsStandardRecipe.add(whippedCreamDefined);
    }
}
