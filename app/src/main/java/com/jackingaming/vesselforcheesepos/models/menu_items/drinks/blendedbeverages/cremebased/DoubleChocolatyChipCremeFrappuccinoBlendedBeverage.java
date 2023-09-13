package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.FrapChips;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class DoubleChocolatyChipCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = DoubleChocolatyChipCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "DoubleChocolatyChipCremeFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Double Chocolaty Chip Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash. Top it off with sweetened whipped cream and mocha drizzle for a real party in your mouth.";
    public static final int DEFAULT_CALORIES = 410;
    public static final int DEFAULT_SUGAR_IN_GRAM = 47;
    public static final float DEFAULT_FAT_IN_GRAM = 20.0f;

    public static final FrapChips.Type DEFAULT_FRAP_CHIPS = FrapChips.Type.FRAP_CHIPS;
    public static final Sauce.Type DEFAULT_SAUCE_MOCHA = Sauce.Type.MOCHA_SAUCE;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Drizzle.Type DEFAULT_DRIZZLE_MOCHA = Drizzle.Type.MOCHA_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_MOCHA_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public DoubleChocolatyChipCremeFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: BLENDED_OPTIONS: FrapChips
        FrapChips frapChips = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof FrapChips) {
                frapChips = (FrapChips) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(frapChips);
        drinkComponents.get(BlendedOptions.TAG).remove(1);

        // BLENDED_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        FrapChips frapChipsDefined = new FrapChips(DEFAULT_FRAP_CHIPS, numberOfScoopByDrinkSize);

        List<DrinkComponentWithDefaultAsString> blendedOptions = drinkComponents.get(BlendedOptions.TAG);
        blendedOptions.add(0, new DrinkComponentWithDefaultAsString(
                frapChipsDefined, Integer.toString(numberOfScoopByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(frapChipsDefined);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Sauce sauceMocha = new Sauce(DEFAULT_SAUCE_MOCHA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                sauceMocha, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(sauceMocha);

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
        Drizzle drizzleMocha = new Drizzle(DEFAULT_DRIZZLE_MOCHA, DEFAULT_DRIZZLE_MOCHA_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleMocha, DEFAULT_DRIZZLE_MOCHA_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleMocha);
    }
}
