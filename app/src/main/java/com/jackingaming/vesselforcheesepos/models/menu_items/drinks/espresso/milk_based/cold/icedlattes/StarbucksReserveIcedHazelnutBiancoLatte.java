package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.ReserveEspressoShots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.ReserveRoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class StarbucksReserveIcedHazelnutBiancoLatte extends IcedLattes {
    public static final String TAG = StarbucksReserveIcedHazelnutBiancoLatte.class.getSimpleName();

    public static final String ID = "StarbucksReserveIcedHazelnutBiancoLatte";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Reserve Iced Hazelnut Bianco Latte";
    public static final String DEFAULT_DESCRIPTION = "House-made hazelnut-praline-infused milk combined with our small-lot Starbucks Reserve espresso and served over ice--a true character of sweetly chilled nut love.";
    public static final int DEFAULT_CALORIES = 280;
    public static final int DEFAULT_SUGAR_IN_GRAM = 26;
    public static final float DEFAULT_FAT_IN_GRAM = 13.0f;

    public static final ReserveEspressoShots.Type DEFAULT_RESERVE_ESPRESSO_SHOTS = ReserveEspressoShots.Type.RESERVE_ESPRESSO_SHOT;
    public static final int DEFAULT_NUMBER_OF_RESERVE_ESPRESSO_SHOTS_MIN = 1;
    public static final ReserveRoastOptionsAllowable.Type DEFAULT_RESERVE_ROAST_OPTIONS_ALLOWABLE = ReserveRoastOptionsAllowable.Type.NONE;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksReserveIcedHazelnutBiancoLatte() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: MILK_OPTIONS: MilkBase
        MilkBase milkBase = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof MilkBase) {
                milkBase = (MilkBase) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(milkBase);
        drinkComponents.get(MilkOptions.TAG).remove(0);

        // REMOVAL: MILK_OPTIONS
        drinkComponents.remove(MilkOptions.TAG);

        // REMOVAL: ESPRESSO_OPTIONS: Shots
        Shots shots = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Shots) {
                shots = (Shots) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(shots);
        drinkComponents.get(EspressoOptions.TAG).remove(1);

        // REMOVAL: ESPRESSO_OPTIONS: RoastOptions
        RoastOptions roastOptions = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof RoastOptions) {
                roastOptions = (RoastOptions) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(roastOptions);
        drinkComponents.get(EspressoOptions.TAG).remove(0);

        // ESPRESSO_OPTIONS: ReserveEspressoShots (add into EXISTING DrinkComponent group)
        // ESPRESSO_OPTIONS: ReserveRoastOptionsAllowable (add into EXISTING DrinkComponent group)
        int numberOfShotByDrinkSize = getNumberOfShotByDrinkSize(drinkSize);
        ReserveEspressoShots reserveEspressoShots = new ReserveEspressoShots(DEFAULT_RESERVE_ESPRESSO_SHOTS, numberOfShotByDrinkSize);
        reserveEspressoShots.setQuantityMin(DEFAULT_NUMBER_OF_RESERVE_ESPRESSO_SHOTS_MIN);

        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(0, new DrinkComponentWithDefaultAsString(
                reserveEspressoShots, Integer.toString(numberOfShotByDrinkSize)
        ));
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                new ReserveRoastOptionsAllowable(null), DEFAULT_RESERVE_ROAST_OPTIONS_ALLOWABLE.name()
        ));

        drinkComponentsStandardRecipe.add(reserveEspressoShots);

        // REMOVAL: TEA_OPTIONS
        drinkComponents.remove(TeaOptions.TAG);

        // REMOVAL: TOPPING_OPTIONS: CinnamonPowder, Drizzle, Topping, WhippedCream
        drinkComponents.get(ToppingOptions.TAG).remove(4);
        drinkComponents.get(ToppingOptions.TAG).remove(3);
        drinkComponents.get(ToppingOptions.TAG).remove(2);
        drinkComponents.get(ToppingOptions.TAG).remove(1);

        // REMOVAL: ADD_INS_OPTIONS: Powders
        drinkComponents.get(AddInsOptions.TAG).remove(2);

        // REMOVAL: CUP_OPTIONS
        CupSize cupSize = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof CupSize) {
                cupSize = (CupSize) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(cupSize);
        drinkComponents.remove(CupOptions.TAG);
    }
}
