package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;

import java.util.List;

public class IcedShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedShakenEspresso.class.getSimpleName();

    public static final String ID = "IcedShakenEspresso";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "Made with the rich, full-bodied espresso you love--then shaken, chilled and mellowed with sweetness and a touch of milk to create a delightfully and deliciously convenient on-the-go drink.";
    public static final int DEFAULT_CALORIES = 100;
    public static final int DEFAULT_SUGAR_IN_GRAM = 14;
    public static final float DEFAULT_FAT_IN_GRAM = 2.0f;

    public static final Liquid.Type DEFAULT_LIQUID_CLASSIC = Liquid.Type.CLASSIC;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedShakenEspresso() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // SWEETENER_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquidClassic = new Liquid(DEFAULT_LIQUID_CLASSIC, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquidClassic, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(liquidClassic);

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
