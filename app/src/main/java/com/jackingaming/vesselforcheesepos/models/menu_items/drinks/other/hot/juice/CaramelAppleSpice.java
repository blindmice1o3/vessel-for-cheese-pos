package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.juice;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.HotOther;

import java.util.ArrayList;
import java.util.List;

public class CaramelAppleSpice extends HotOther {
    public static final String TAG = CaramelAppleSpice.class.getSimpleName();

    public static final String ID = "CaramelAppleSpice";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caramel Apple Spice";
    public static final String DEFAULT_DESCRIPTION = "Steamed apple juice complemented with cinnamon syrup, whipped cream and a caramel sauce drizzle.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 70;
    public static final float DEFAULT_FAT_IN_GRAM = 8.0f;

    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final Syrup.Type DEFAULT_SYRUP_CINNAMON_DOLCE = Syrup.Type.CINNAMON_DOLCE_SYRUP;
    public static final Drizzle.Type DEFAULT_DRIZZLE_CARAMEL = Drizzle.Type.CARAMEL_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_CARAMEL_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final String DEFAULT_FRUITS = DrinkComponent.NULL_TYPE_AS_STRING;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelAppleSpice() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
        ));

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupCinnamonDolce = new Syrup(DEFAULT_SYRUP_CINNAMON_DOLCE, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupCinnamonDolce, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(syrupCinnamonDolce);

        // TOPPING_OPTIONS
        Drizzle drizzleCaramel = new Drizzle(DEFAULT_DRIZZLE_CARAMEL, DEFAULT_DRIZZLE_CARAMEL_AMOUNT);
        WhippedCream whippedCream = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                drizzleCaramel, DEFAULT_DRIZZLE_CARAMEL_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                whippedCream, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleCaramel);
        drinkComponentsStandardRecipe.add(whippedCream);

        drinkComponents.put(ToppingOptions.TAG, toppingOptions);

        // ADD_INS_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Fruits(Fruits.DUMMY_ID), DEFAULT_FRUITS
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Ice(null, DEFAULT_ICE_AMOUNT), DEFAULT_ICE_AMOUNT.name()
        ));
        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }
}
