package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.steamers;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.HotOther;

import java.util.ArrayList;
import java.util.List;

public class PumpkinSpiceCreme extends HotOther {
    public static final String TAG = PumpkinSpiceCreme.class.getSimpleName();

    public static final String ID = "PumpkinSpiceCreme";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Pumpkin Spice Creme";
    public static final String DEFAULT_DESCRIPTION = "We combine steamed milk with flavors of pumpkin, cinnamon, nutmeg and clove, then top it all off with whipped cream to create this amazing, coffee-free fall favorite.";
    public static final int DEFAULT_CALORIES = 400;
    public static final int DEFAULT_SUGAR_IN_GRAM = 52;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MILK_FOAM;
    public static final Granular.Amount DEFAULT_MILK_FOAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final Sauce.Type DEFAULT_SAUCE_PUMPKIN = Sauce.Type.PUMPKIN_SAUCE;
    public static final Topping.Type DEFAULT_TOPPING_PUMPKIN_SPICE = Topping.Type.PUMPKIN_SPICE_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT = Granular.Amount.MEDIUM;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public PumpkinSpiceCreme() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkFoam milkFoamMedium = new MilkFoam(DEFAULT_MILK_FOAM, DEFAULT_MILK_FOAM_AMOUNT);
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);
        Temperature temperatureMedium = new Temperature(DEFAULT_TEMPERATURE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkFoamMedium, DEFAULT_MILK_FOAM_AMOUNT.name()
        ));
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                temperatureMedium, DEFAULT_TEMPERATURE.name()
        ));
        drinkComponentsStandardRecipe.add(milkFoamMedium);
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);
        drinkComponentsStandardRecipe.add(temperatureMedium);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Sauce saucePumpkin = new Sauce(DEFAULT_SAUCE_PUMPKIN, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                saucePumpkin, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(saucePumpkin);

        // TOPPING_OPTIONS
        Topping toppingPumpkinSpice = new Topping(DEFAULT_TOPPING_PUMPKIN_SPICE, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT);
        WhippedCream whippedCream = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                toppingPumpkinSpice, DEFAULT_TOPPING_PUMPKIN_SPICE_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                whippedCream, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new CinnamonPowder(null, DEFAULT_CINNAMON_POWDER_AMOUNT), DEFAULT_CINNAMON_POWDER_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new Drizzle(null, DEFAULT_DRIZZLE_AMOUNT), DEFAULT_DRIZZLE_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new Topping(null, DEFAULT_TOPPING_AMOUNT), DEFAULT_TOPPING_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(toppingPumpkinSpice);
        drinkComponentsStandardRecipe.add(whippedCream);

        drinkComponents.put(ToppingOptions.TAG, toppingOptions);

        // ADD_INS_OPTIONS
        LineTheCup lineTheCup = new LineTheCup(DEFAULT_LINE_THE_CUP);
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                lineTheCup, DEFAULT_LINE_THE_CUP.name()
        ));
        drinkComponentsStandardRecipe.add(lineTheCup);

        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }
}
