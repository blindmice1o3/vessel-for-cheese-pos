package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites.IcedFlatWhites;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedLattes;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmacchiatos.IcedMacchiatos;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.IcedMochas;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.StarbucksReserveIcedDarkChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedShakenEspressos;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.cappuccinos.Cappuccinos;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites.FlatWhites;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.Lattes;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.EspressoMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.Macchiatos;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.mochas.Mochas;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.mochas.StarbucksReserveDarkChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.cold.icedamericano.IcedAmericano;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.hot.americanos.Americanos;

import java.util.ArrayList;
import java.util.List;

public abstract class Espresso extends Drink {
    public static final String TAG = Espresso.class.getSimpleName();

    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS = RoastOptions.Type.SIGNATURE;
    public static final Shots.Type DEFAULT_SHOT = Shots.Type.SHOT;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN = 1;
    public static final PullOptionsAllowable.Type DEFAULT_PULL_OPTIONS = PullOptionsAllowable.Type.NONE;
    public static final PrepOptions.Type DEFAULT_PREP_OPTIONS = PrepOptions.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_CHAI_SCOOPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_COLD_FOAM_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.NO;

    public Espresso() {
    }

    public Espresso(String id, int imageResourceId, String name, String description,
                    int calories, int sugarInGram, float fatInGram,
                    double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);

        // ESPRESSO_OPTIONS
        List<DrinkComponentWithDefaultAsString> espressoOptions = new ArrayList<>();
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new RoastOptions(DEFAULT_ROAST_OPTIONS), DEFAULT_ROAST_OPTIONS.name()
        ));
        int numberOfShotByDrinkSize = getNumberOfShotByDrinkSize(drinkSize);
        Shots shots = new Shots(DEFAULT_SHOT, numberOfShotByDrinkSize);
        shots.setQuantityMin(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN);
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                shots, Integer.toString(numberOfShotByDrinkSize)
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new PullOptionsAllowable(null), DEFAULT_PULL_OPTIONS.name()
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new PrepOptions(null), DEFAULT_PREP_OPTIONS.name()
        ));
        // TEA_OPTIONS
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_SCOOPS)
        ));
        // SWEETENER_OPTIONS
        List<DrinkComponentWithDefaultAsString> sweetenerOptions = new ArrayList<>();
        sweetenerOptions.add(new DrinkComponentWithDefaultAsString(
                new Liquid(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS)
        ));
        sweetenerOptions.add(new DrinkComponentWithDefaultAsString(
                new Packet(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS)
        ));
        // FLAVOR_OPTIONS
        List<DrinkComponentWithDefaultAsString> flavorOptions = new ArrayList<>();
        flavorOptions.add(new DrinkComponentWithDefaultAsString(
                new Sauce(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS)
        ));
        flavorOptions.add(new DrinkComponentWithDefaultAsString(
                new Syrup(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS)
        ));
        // TOPPING_OPTIONS
        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new ColdFoam(null, DEFAULT_COLD_FOAM_AMOUNT), DEFAULT_COLD_FOAM_AMOUNT.name()
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
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new WhippedCream(null, DEFAULT_WHIPPED_CREAM_AMOUNT), DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        // ADD_INS_OPTIONS
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new LineTheCup(DEFAULT_LINE_THE_CUP), DEFAULT_LINE_THE_CUP.name()
        ));
        // CUP_OPTIONS
        List<DrinkComponentWithDefaultAsString> cupOptions = new ArrayList<>();
        cupOptions.add(new DrinkComponentWithDefaultAsString(
                new CupSize(DEFAULT_CUP_SIZE), DEFAULT_CUP_SIZE.name()
        ));

        drinkComponents.put(EspressoOptions.TAG, espressoOptions);
        drinkComponents.put(TeaOptions.TAG, teaOptions);
        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);
        drinkComponents.put(FlavorOptions.TAG, flavorOptions);
        drinkComponents.put(ToppingOptions.TAG, toppingOptions);
        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
        drinkComponents.put(CupOptions.TAG, cupOptions);

        for (String key : Menu.DRINK_COMPONENTS_KEYS) {
            if (drinkComponents.containsKey(key)) {
                List<DrinkComponentWithDefaultAsString> drinkComponentsGroup = drinkComponents.get(key);
                for (DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString : drinkComponentsGroup) {
                    DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
                    if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                        continue;
                    } else {
                        drinkComponentsStandardRecipe.add(drinkComponent);
                    }
                }
            }
        }
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        if (this instanceof StarbucksReserveLatte || this instanceof StarbucksReserveIcedLatte ||
                this instanceof StarbucksReserveDarkChocolateMocha || this instanceof StarbucksReserveIcedDarkChocolateMocha) {
            Log.i(TAG, "this instanceof StarbucksReserveLatte || this instanceof StarbucksReserveIcedLatte || this instanceof StarbucksReserveDarkChocolateMocha || this instanceof StarbucksReserveIcedDarkChocolateMocha");
            switch (drinkSizeNew) {
                case SHORT:
                case TALL:
                case GRANDE:
                    numberOfShotNew = 2;
                    break;
                case VENTI_HOT:
                case VENTI_ICED:
                    numberOfShotNew = 4;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof StarbucksReserveHazelnutBiancoLatte || this instanceof StarbucksReserveIcedHazelnutBiancoLatte) {
            Log.i(TAG, "this instanceof StarbucksReserveLatte || this instanceof StarbucksReserveIcedHazelnutBiancoLatte");
            switch (drinkSizeNew) {
                case SHORT:
                case TALL:
                case GRANDE:
                    numberOfShotNew = 2;
                    break;
                case VENTI_HOT:
                case VENTI_ICED:
                    numberOfShotNew = 3;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof Lattes || this instanceof IcedLattes ||
                this instanceof Mochas || this instanceof IcedMochas ||
                this instanceof Cappuccinos || this instanceof IcedMacchiatos ||
                this instanceof Macchiatos && !(this instanceof EspressoMacchiato)) {
            Log.i(TAG, "this instanceof Lattes || this instanceof IcedLattes || this instanceof Mochas || this instanceof IcedMochas || this instanceof Cappuccinos || this instanceof IcedMacchiatos || this instanceof Macchiatos && !(this instanceof EspressoMacchiato)");
            // TODO: double check on EspressoMacchiato shot-by-DrinkSize
            switch (drinkSizeNew) {
                case SHORT:
                case TALL:
                    numberOfShotNew = 1;
                    break;
                case GRANDE:
                case VENTI_HOT:
                    numberOfShotNew = 2;
                    break;
                case VENTI_ICED:
                    numberOfShotNew = 3;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof Americanos || this instanceof IcedAmericano) {
            Log.i(TAG, "this instanceof Americanos || this instanceof IcedAmericano");
            switch (drinkSizeNew) {
                case SHORT:
                    numberOfShotNew = 1;
                    break;
                case TALL:
                    numberOfShotNew = 2;
                    break;
                case GRANDE:
                    numberOfShotNew = 3;
                    break;
                case VENTI_HOT:
                case VENTI_ICED:
                    numberOfShotNew = 4;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof FlatWhites || this instanceof IcedFlatWhites ||
                this instanceof IcedShakenEspressos) {
            Log.i(TAG, "this instanceof FlatWhites || this instanceof IcedFlatWhites || this instanceof IcedShakenEspressos");
            switch (drinkSizeNew) {
                case SHORT:
                case TALL:
                    numberOfShotNew = 2;
                    break;
                case GRANDE:
                case VENTI_HOT:
                    numberOfShotNew = 3;
                    break;
                case VENTI_ICED:
                    numberOfShotNew = 4;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else {
            Log.e(TAG, "else-clause");
        }

        return numberOfShotNew;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        if (this instanceof Lattes || this instanceof IcedLattes ||
                this instanceof Mochas || this instanceof IcedMochas ||
                this instanceof Americanos || this instanceof IcedAmericano ||
                this instanceof FlatWhites || this instanceof IcedFlatWhites ||
                this instanceof IcedShakenEspressos ||
                this instanceof Cappuccinos) {
            Log.i(TAG, "this instanceof Lattes || this instanceof IcedLattes || this instanceof Mochas || this instanceof IcedMochas || this instanceof Americanos || this instanceof IcedAmericano || this instanceof FlatWhites || this instanceof IcedShakenEspressos || this instanceof Cappuccinos");
            switch (drinkSizeNew) {
                case SHORT:
                    numberOfPumpNew = 2;
                    break;
                case TALL:
                    numberOfPumpNew = 3;
                    break;
                case GRANDE:
                    numberOfPumpNew = 4;
                    break;
                case VENTI_HOT:
                    numberOfPumpNew = 5;
                    break;
                case VENTI_ICED:
                    numberOfPumpNew = 6;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof Macchiatos && !(this instanceof EspressoMacchiato)
                || this instanceof IcedMacchiatos) {
            Log.i(TAG, "this instanceof Macchiatos && !(this instanceof EspressoMacchiato) || this instanceof IcedMacchiatos");
            // TODO: double check on EspressoMacchiato shot-by-DrinkSize
            switch (drinkSizeNew) {
                case SHORT:
                    numberOfPumpNew = 1;
                    break;
                case TALL:
                    numberOfPumpNew = 2;
                    break;
                case GRANDE:
                    numberOfPumpNew = 3;
                    break;
                case VENTI_HOT:
                    numberOfPumpNew = 4;
                    break;
                case VENTI_ICED:
                    numberOfPumpNew = 5;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else {
            Log.e(TAG, "else-clause");
        }

        return numberOfPumpNew;
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfScoopNew = 1;
                break;
            case TALL:
                numberOfScoopNew = 2;
                break;
            case GRANDE:
                numberOfScoopNew = 3;
                break;
            case VENTI_HOT:
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

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }
}