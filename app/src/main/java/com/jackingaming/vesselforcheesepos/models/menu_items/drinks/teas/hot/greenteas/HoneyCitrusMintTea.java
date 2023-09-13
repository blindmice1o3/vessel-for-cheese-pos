package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.greenteas;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Room;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaBag;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.HotTeas;

import java.util.ArrayList;
import java.util.List;

public class HoneyCitrusMintTea extends HotTeas {
    public static final String TAG = HoneyCitrusMintTea.class.getSimpleName();

    public static final String ID = "HoneyCitrusMintTea";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Honey Citrus Mint Tea";
    public static final String DEFAULT_DESCRIPTION = "A customer creation so popular it's now on the menu. Jade Citrus Mint green tea, Peach Tranquility herbal tea, hot water, steamed lemonade and a touch of honey mingle tastefully well together for a tea that comforts from the inside out.";
    public static final int DEFAULT_CALORIES = 130;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Lemonade.Type DEFAULT_LEMONADE = Lemonade.Type.LEMONADE;
    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.MEDIUM;
    public static final TeaBag.Type DEFAULT_TEA_BAG = TeaBag.Type.TEA_BAG;
    public static final Liquid.Type DEFAULT_LIQUID_HONEY_BLEND = Liquid.Type.HONEY_BLEND;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_ROOM_AMOUNT = Granular.Amount.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public HoneyCitrusMintTea() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // LEMONADE_OPTIONS
        Lemonade lemonade = new Lemonade(DEFAULT_LEMONADE, DEFAULT_LEMONADE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                lemonade, DEFAULT_LEMONADE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(lemonade);

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);

        // TEA_OPTIONS
        int numberOfTeaBagByDrinkSize = getNumberOfTeaBagByDrinkSize(drinkSize);
        TeaBag teaBag = new TeaBag(DEFAULT_TEA_BAG, numberOfTeaBagByDrinkSize);

        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                teaBag, Integer.toString(numberOfTeaBagByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(teaBag);

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquid = new Liquid(DEFAULT_LIQUID_HONEY_BLEND, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquid, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(liquid);

        // ADD_INS_OPTIONS
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT), DEFAULT_MILK_CREAMER_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Room(null, DEFAULT_ROOM_AMOUNT), DEFAULT_ROOM_AMOUNT.name()
        ));

        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfPumpNew = 1;
                break;
            case TALL:
                numberOfPumpNew = 1;
                break;
            case GRANDE:
                numberOfPumpNew = 2;
                break;
            case VENTI_HOT:
                numberOfPumpNew = 2;
                break;
            case VENTI_ICED:
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }
}
