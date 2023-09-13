package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

import java.util.ArrayList;
import java.util.List;

public class ColdMilk extends ColdOther {
    public static final String TAG = ColdMilk.class.getSimpleName();

    public static final String ID = "ColdMilk";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Cold Milk";
    public static final String DEFAULT_DESCRIPTION = "Skim, 2%, soy, almond, or coconutmilk served chilled or over ice. Simply refreshing.";
    public static final int DEFAULT_CALORIES = 260;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 10.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public ColdMilk() {
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

        // TEA_OPTIONS (remove DrinkComponent group)
        drinkComponents.remove(TeaOptions.TAG);

        // JUICE_OPTIONS (remove DrinkComponent group)
        drinkComponents.remove(JuiceOptions.TAG);

        // SWEETENER_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> sweetenerOptions = new ArrayList<>();
        sweetenerOptions.add(new DrinkComponentWithDefaultAsString(
                new Liquid(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS)
        ));
        sweetenerOptions.add(new DrinkComponentWithDefaultAsString(
                new Packet(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS)
        ));

        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);

        // FLAVOR_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> flavorOptions = new ArrayList<>();
        flavorOptions.add(new DrinkComponentWithDefaultAsString(
                new Sauce(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS)
        ));
        flavorOptions.add(new DrinkComponentWithDefaultAsString(
                new Syrup(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS)
        ));

        drinkComponents.put(FlavorOptions.TAG, flavorOptions);

        // TOPPING_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new CinnamonPowder(null, DEFAULT_CINNAMON_POWDER_AMOUNT), DEFAULT_CINNAMON_POWDER_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new Drizzle(null, DEFAULT_DRIZZLE_AMOUNT), DEFAULT_DRIZZLE_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new Topping(null, DEFAULT_TOPPING_AMOUNT), DEFAULT_TOPPING_AMOUNT.name()
        ));
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new WhippedCream(null, DEFAULT_WHIPPED_CREAM_AMOUNT), DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));

        drinkComponents.put(ToppingOptions.TAG, toppingOptions);

        // ADD_INS_OPTIONS (add into NEW DrinkComponent group)
        LineTheCup lineTheCup = new LineTheCup(DEFAULT_LINE_THE_CUP);

        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                lineTheCup, DEFAULT_LINE_THE_CUP.name()
        ));
        drinkComponentsStandardRecipe.add(lineTheCup);

        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }
}
