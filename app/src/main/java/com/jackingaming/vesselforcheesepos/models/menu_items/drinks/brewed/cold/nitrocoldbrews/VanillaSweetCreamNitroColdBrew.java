package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.nitrocoldbrews;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;

import java.util.List;

public class VanillaSweetCreamNitroColdBrew extends NitroColdBrews {
    public static final String TAG = VanillaSweetCreamNitroColdBrew.class.getSimpleName();

    public static final String ID = "VanillaSweetCreamNitroColdBrew";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Vanilla Sweet Cream Nitro Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Served cold, straight from the tap, our Nitro Cold Brew is topped with a float of house-made vanilla sweet cream. The result: a cascade of velvety coffee more sippable than ever.";
    public static final int DEFAULT_CALORIES = 70;
    public static final int DEFAULT_SUGAR_IN_GRAM = 4;
    public static final float DEFAULT_FAT_IN_GRAM = 5.0f;

    public static final MilkCreamer.Type DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM = MilkCreamer.Type.VANILLA_SWEET_CREAM;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public VanillaSweetCreamNitroColdBrew() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        MilkCreamer milkCreamerVanillaSweetCream = new MilkCreamer(DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM, DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                milkCreamerVanillaSweetCream, DEFAULT_MILK_CREAMER_VANILLA_SWEET_CREAM_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(milkCreamerVanillaSweetCream);
    }
}
