package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.MatchaPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class MatchaCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = MatchaCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "MatchaCremeFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Matcha Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "This blend of sweetened premium matcha green tea, milk and ice--topped off with sweetened whipped cream--inspires a delicious boost and good green vibes.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 61;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final MatchaPowder.Type DEFAULT_MATCHA_POWDER = MatchaPowder.Type.MATCHA_POWDER;
    public static final Liquid.Type DEFAULT_LIQUID_CLASSIC = Liquid.Type.CLASSIC;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MatchaCremeFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // TEA_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        MatchaPowder matchaPowder = new MatchaPowder(DEFAULT_MATCHA_POWDER, numberOfScoopByDrinkSize);

        List<DrinkComponentWithDefaultAsString> teaOptions = drinkComponents.get(TeaOptions.TAG);
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                matchaPowder, Integer.toString(numberOfScoopByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(matchaPowder);

        // SWEETENER_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquidClassic = new Liquid(DEFAULT_LIQUID_CLASSIC, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquidClassic, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(liquidClassic);

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
    }
}
