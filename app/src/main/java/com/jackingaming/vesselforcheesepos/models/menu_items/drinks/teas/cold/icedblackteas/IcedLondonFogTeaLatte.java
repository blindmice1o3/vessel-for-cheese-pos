package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedblackteas;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.MatchaPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaBag;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.IcedTeas;

import java.util.ArrayList;
import java.util.List;

public class IcedLondonFogTeaLatte extends IcedTeas {
    public static final String TAG = IcedLondonFogTeaLatte.class.getSimpleName();

    public static final String ID = "IcedLondonFogTeaLatte";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced London Fog Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Bright, citrusy spark of bergamot blends with subtle hints of lavender and mixes with vanilla syrup, milk and ice to create this delicious reinvention of a classic Earl Grey tea.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 0;
    public static final TeaBag.Type DEFAULT_TEA_BAG = TeaBag.Type.TEA_BAG;
    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_MATCHA_SCOOPS = 0;
    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA_SYRUP;
    public static final int DEFAULT_NUMBER_OF_SAUCE_PUMPS = 0;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedLondonFogTeaLatte() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ESPRESSO_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> espressoOptions = new ArrayList<>();
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new RoastOptionsAllowable(null), DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new Shots(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS)
        ));

        drinkComponents.put(EspressoOptions.TAG, espressoOptions);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        int numberOfTeaBagByDrinkSize = getNumberOfTeaBagByDrinkSize(drinkSize);
        TeaBag teaBag = new TeaBag(DEFAULT_TEA_BAG, numberOfTeaBagByDrinkSize);

        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                teaBag, Integer.toString(numberOfTeaBagByDrinkSize)
        ));
        teaOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
        ));
        teaOptions.add(2, new DrinkComponentWithDefaultAsString(
                new MatchaPowder(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_MATCHA_SCOOPS)
        ));
        drinkComponentsStandardRecipe.add(teaBag);

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupVanilla = new Syrup(DEFAULT_SYRUP_VANILLA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupVanilla, Integer.toString(numberOfPumpByDrinkSize)
        ));
        flavorOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Sauce(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SAUCE_PUMPS)
        ));
        drinkComponentsStandardRecipe.add(syrupVanilla);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(1, new DrinkComponentWithDefaultAsString(
                new CinnamonPowder(null, DEFAULT_CINNAMON_POWDER_AMOUNT), DEFAULT_CINNAMON_POWDER_AMOUNT.name()
        ));
        toppingOptions.add(2, new DrinkComponentWithDefaultAsString(
                new Drizzle(null, DEFAULT_DRIZZLE_AMOUNT), DEFAULT_DRIZZLE_AMOUNT.name()
        ));
        toppingOptions.add(3, new DrinkComponentWithDefaultAsString(
                new Topping(null, DEFAULT_TOPPING_AMOUNT), DEFAULT_TOPPING_AMOUNT.name()
        ));
        toppingOptions.add(4, new DrinkComponentWithDefaultAsString(
                new WhippedCream(null, DEFAULT_WHIPPED_CREAM_AMOUNT), DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));

        // CUP_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> cupOptions = new ArrayList<>();
        CupSize cupSize = new CupSize(DEFAULT_CUP_SIZE);
        cupOptions.add(new DrinkComponentWithDefaultAsString(
                cupSize, DEFAULT_CUP_SIZE.name()
        ));
        drinkComponentsStandardRecipe.add(cupSize);

        drinkComponents.put(CupOptions.TAG, cupOptions);
    }
}
