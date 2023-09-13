package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;

import java.util.List;

public class VanillaSweetCreamColdBrew extends ColdBrews {
    public static final String TAG = VanillaSweetCreamColdBrew.class.getSimpleName();

    public static final String ID = "VanillaSweetCreamColdBrew";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Vanilla Sweet Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Our slow-steeped custom blend of Starbucks Cold Brew coffee accented with vanilla and topped with a delicate float of house-made vanilla sweet cream that cascades throughout the cup. It's over-the-top and super-smooth.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 14;
    public static final float DEFAULT_FAT_IN_GRAM = 5.0f;

    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA_SYRUP;
    public static final MilkCreamer.Type DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM = MilkCreamer.Type.VANILLA_SWEET_CREAM;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public VanillaSweetCreamColdBrew() {
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

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        MilkCreamer milkCreamerVanillaSweetCream = new MilkCreamer(DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM, DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                milkCreamerVanillaSweetCream, DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(milkCreamerVanillaSweetCream);
    }
}
