package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Room;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
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
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.BrewedCoffees;

import java.util.ArrayList;
import java.util.List;

public abstract class ColdBrewedCoffees extends BrewedCoffees {
    public static final String TAG = ColdBrewedCoffees.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED, DrinkSize.TRENTA};

    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 0;
    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_COLD_FOAM_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_ROOM_AMOUNT = Granular.Amount.NO;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.NO;

    public ColdBrewedCoffees() {
    }

    public ColdBrewedCoffees(String id, int imageResourceId, String name, String description,
                             int calories, int sugarInGram, float fatInGram,
                             double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // ESPRESSO_OPTIONS
        List<DrinkComponentWithDefaultAsString> espressoOptions = new ArrayList<>();
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new RoastOptionsAllowable(null), DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new Shots(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS)
        ));
        // TEA_OPTIONS
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
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
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new LineTheCup(DEFAULT_LINE_THE_CUP), DEFAULT_LINE_THE_CUP.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Powders(Powders.DUMMY_ID), DEFAULT_POWDERS
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT), DEFAULT_MILK_CREAMER_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Room(null, DEFAULT_ROOM_AMOUNT), DEFAULT_ROOM_AMOUNT.name()
        ));
        // CUP_OPTIONS
        List<DrinkComponentWithDefaultAsString> cupOptions = new ArrayList<>();
        CupSize cupSize = new CupSize(DEFAULT_CUP_SIZE);
        cupOptions.add(new DrinkComponentWithDefaultAsString(
                cupSize, DEFAULT_CUP_SIZE.name()
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
}
