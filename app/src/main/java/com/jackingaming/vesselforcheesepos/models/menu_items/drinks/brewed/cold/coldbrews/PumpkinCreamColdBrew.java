package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class PumpkinCreamColdBrew extends ColdBrews {
    public static final String TAG = PumpkinCreamColdBrew.class.getSimpleName();

    public static final String ID = "PumpkinCreamColdBrew";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Pumpkin Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Cold Brew sweetened with vanilla syrup and topped with pumpkin cream cold foam and a dusting of pumpkin-spice topping.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 31;
    public static final float DEFAULT_FAT_IN_GRAM = 12.0f;

    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA_SYRUP;
    public static final ColdFoam.Type DEFAULT_COLD_FOAM_PUMPKIN_CREAM = ColdFoam.Type.PUMPKIN_CREAM_COLD_FOAM;
    public static final Granular.Amount DEFAULT_COLD_FOAM_PUMPKIN_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Topping.Type DEFAULT_TOPPING_PUMPKIN_SPICE = Topping.Type.PUMPKIN_SPICE_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public PumpkinCreamColdBrew() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupVanilla = new Syrup(DEFAULT_SYRUP_VANILLA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupVanilla, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(syrupVanilla);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        ColdFoam coldFoamPumpkinCream = new ColdFoam(DEFAULT_COLD_FOAM_PUMPKIN_CREAM, DEFAULT_COLD_FOAM_PUMPKIN_CREAM_AMOUNT);
        Topping toppingPumpkinSpice = new Topping(DEFAULT_TOPPING_PUMPKIN_SPICE, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                coldFoamPumpkinCream, DEFAULT_COLD_FOAM_PUMPKIN_CREAM_AMOUNT.name()
        ));
        toppingOptions.add(1, new DrinkComponentWithDefaultAsString(
                toppingPumpkinSpice, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(coldFoamPumpkinCream);
        drinkComponentsStandardRecipe.add(toppingPumpkinSpice);
    }
}
