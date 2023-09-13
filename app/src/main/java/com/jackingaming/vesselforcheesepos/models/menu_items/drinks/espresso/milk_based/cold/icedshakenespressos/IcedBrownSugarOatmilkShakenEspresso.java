package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;

import java.util.ArrayList;
import java.util.List;

public class IcedBrownSugarOatmilkShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedBrownSugarOatmilkShakenEspresso.class.getSimpleName();

    public static final String ID = "IcedBrownSugarOatmilkShakenEspresso";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Brown Sugar Oatmilk Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "First we shake Starbucks Blonde espresso, brown sugar and cinnamon together, and then top it off with oatmilk and ice for a cool lift to power you through your day.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 12;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final MilkBase.Type DEFAULT_MILK_BASE_OATMILK = MilkBase.Type.OATMILK;
    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final Syrup.Type DEFAULT_SYRUP_BROWN_SUGAR = Syrup.Type.BROWN_SUGAR_SYRUP;
    public static final CinnamonPowder.Type DEFAULT_CINNAMON_POWDER = CinnamonPowder.Type.CINNAMON_POWDER;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedBrownSugarOatmilkShakenEspresso() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // PREPARATION_OPTIONS (add into NEW DrinkComponent group)
        PreparationMethod preparationMethod = new PreparationMethod(DEFAULT_PREPARATION_METHOD);

        List<DrinkComponentWithDefaultAsString> preparationOptions = new ArrayList<>();
        preparationOptions.add(new DrinkComponentWithDefaultAsString(
                preparationMethod, DEFAULT_PREPARATION_METHOD.name()
        ));
        drinkComponentsStandardRecipe.add(preparationMethod);

        drinkComponents.put(PreparationOptions.TAG, preparationOptions);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_OATMILK);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_OATMILK.name());

        // REMOVAL: ESPRESSO_OPTIONS: RoastOptions (replace with RoastOptionsAllowable)
        drinkComponents.get(EspressoOptions.TAG).remove(0);

        // ESPRESSO_OPTIONS (add into EXISTING DrinkComponent group)
        RoastOptionsAllowable roastOptionsAllowable = new RoastOptionsAllowable(null);

        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                roastOptionsAllowable, DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupBrownSugar = new Syrup(DEFAULT_SYRUP_BROWN_SUGAR, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupBrownSugar, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(syrupBrownSugar);

        // REMOVAL: TOPPING_OPTIONS: CinnamonPowder
        drinkComponents.get(ToppingOptions.TAG).remove(1);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        CinnamonPowder cinnamonPowder = new CinnamonPowder(DEFAULT_CINNAMON_POWDER, DEFAULT_CINNAMON_POWDER_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                cinnamonPowder, DEFAULT_CINNAMON_POWDER_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(cinnamonPowder);

        // REMOVAL: ADD_INS_OPTIONS: Ice
        Ice ice = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Ice) {
                ice = (Ice) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(ice);
        drinkComponents.get(AddInsOptions.TAG).remove(0);
    }
}
