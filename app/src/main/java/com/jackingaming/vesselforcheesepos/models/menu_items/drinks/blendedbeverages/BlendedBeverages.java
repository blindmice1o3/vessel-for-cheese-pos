package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedPrep;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.FrapChips;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.AffogatoShots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.ArrayList;
import java.util.List;

public abstract class BlendedBeverages extends Drink {
    public static final String TAG = BlendedBeverages.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.WHOLE_MILK;
    public static final int DEFAULT_NUMBER_OF_AFFOGATO_ESPRESSO_SHOTS = 0;
    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 0;
    public static final BlendedPrep.Type DEFAULT_BLENDED_PREP = BlendedPrep.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_SCOOPS_FRAP_CHIPS = 0;
    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;

    public BlendedBeverages() {
    }

    public BlendedBeverages(String id, int imageResourceId, String name, String description,
                            int calories, int sugarInGram, float fatInGram,
                            double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseWholeMilk = new MilkBase(DEFAULT_MILK_BASE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseWholeMilk, DEFAULT_MILK_BASE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseWholeMilk);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ESPRESSO_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> espressoOptions = new ArrayList<>();
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new AffogatoShots(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_AFFOGATO_ESPRESSO_SHOTS)
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new RoastOptionsAllowable(null), DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new Shots(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS)
        ));

        drinkComponents.put(EspressoOptions.TAG, espressoOptions);

        // BLENDED_OPTIONS (add into NEW DrinkComponent group)
        BlendedPrep blendedPrep = new BlendedPrep(DEFAULT_BLENDED_PREP);

        List<DrinkComponentWithDefaultAsString> blendedOptions = new ArrayList<>();
        blendedOptions.add(new DrinkComponentWithDefaultAsString(
                blendedPrep, DEFAULT_BLENDED_PREP.name()
        ));
        blendedOptions.add(new DrinkComponentWithDefaultAsString(
                new FrapChips(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SCOOPS_FRAP_CHIPS)
        ));
        drinkComponentsStandardRecipe.add(blendedPrep);

        drinkComponents.put(BlendedOptions.TAG, blendedOptions);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
        ));

        drinkComponents.put(TeaOptions.TAG, teaOptions);

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

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfShotNew = 1;
                break;
            case GRANDE:
                numberOfShotNew = 1;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfShotNew = 1;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfShotNew;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfPumpNew = 2;
                break;
            case GRANDE:
                numberOfPumpNew = 3;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfPumpNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfScoopNew = 2;
                break;
            case GRANDE:
                numberOfScoopNew = 3;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfScoopNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfScoopNew;
    }

    @Override
    public int getNumberOfFrapRoastByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfFrapRoastByDrinkSize(DrinkSize)");

        int numberOfFrapRoastNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfFrapRoastNew = 2;
                break;
            case GRANDE:
                numberOfFrapRoastNew = 3;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfFrapRoastNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfFrapRoastNew;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        int numberOfTeaBagNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
            case TALL:
                numberOfTeaBagNew = 1;
                break;
            case GRANDE:
                numberOfTeaBagNew = 2;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfTeaBagNew = 2;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfTeaBagNew;
    }
}
