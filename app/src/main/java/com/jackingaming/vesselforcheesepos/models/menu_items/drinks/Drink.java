package com.jackingaming.vesselforcheesepos.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.FrapChips;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.FrapRoast;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.ReserveEspressoShots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.SyrupSeasonal;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.MatchaPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaBag;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.menu.Menu;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Drink extends MenuItem
        implements DrinkSizeChangeResponder {
    public static final String TAG = Drink.class.getSimpleName();
    public static final int QUANTITY_INDEPENDENT_OF_DRINK_SIZE = -1;

    protected Map<String, List<DrinkComponentWithDefaultAsString>> drinkComponents = new HashMap<>();
    protected List<DrinkComponent> drinkComponentsStandardRecipe = new ArrayList<>();
    protected DrinkSize drinkSize;
    protected DrinkSize[] drinkSizesAllowed;

    public Drink() {
        super();
    }

    public Drink(String id, int imageResourceId, String name, String description,
                 int calories, int sugarInGram, float fatInGram,
                 double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
        this.drinkSize = drinkSizeDefault;
    }

    // TODO: abstract initDrinkComponents()
    // TODO: abstract initDrinkComponentsDefaultAsString()
    // TODO: abstract initDrinkComponentsStandardRecipe()
    // TODO: abstract initDrinkSizesAllowed()
    //  (as oppose to CaffeLatte doing this straight in the constructor).

    public void addToDrinkComponents(String key, DrinkComponent drinkComponent) {
        Log.i(TAG, "addToDrinkComponents(String, DrinkComponent)");
        // TODO: screen for duplication (subclasses should override and add rules-check)
//        drinkComponents.get(key).add(drinkComponent);
    }

    private boolean updateQuantityByDrinkSize(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString, int quantityNew) {
        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
        String drinkComponentDefaultAsString = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();
        Incrementable incrementable = (Incrementable) drinkComponent;
        boolean changedUserCustomizations = false;

        int quantityInDrink = incrementable.getQuantity();
        int quantityDefaultInDrink = Integer.parseInt(drinkComponentDefaultAsString);
        if (quantityInDrink == quantityDefaultInDrink) {
            // user left as default value

            if (quantityInDrink == quantityNew) {
                // new drink size did NOT change quantity
            } else {
                // new drink size CHANGED quantity
                incrementable.setQuantity(quantityNew);
            }
        } else {
            // user had customized

            if (quantityInDrink == quantityNew) {
                // new drink size did NOT change quantity
            } else {
                // new drink size CHANGED quantity
                incrementable.setQuantity(quantityNew);
                changedUserCustomizations = true;
            }
        }

        // update drinkComponent's associate default value
        drinkComponentWithDefaultAsString.setDrinkComponentDefaultAsString(Integer.toString(quantityNew));

        return changedUserCustomizations;
    }

    public boolean updateDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "updateDrinkSize(DrinkSize)");

        this.drinkSize = drinkSizeNew;

        boolean changedUserCustomizations = false;
        // TODO: set changedUserCustomizations to true if altered.
        for (String key : Menu.DRINK_SIZE_CHANGED_KEYS) {
            if (drinkComponents.containsKey(key)) {
                Log.i(TAG, "key: " + key);

                List<DrinkComponentWithDefaultAsString> drinkComponentsGroup = drinkComponents.get(key);
                if (key.equals(AddInsOptions.TAG)) {
                    Log.i(TAG, "key.equals(AddInsOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof VanillaBeanPowder) {
                                Log.i(TAG, "drinkComponent instanceof VanillaBeanPowder");

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            } else if (drinkComponent instanceof FruitInclusion) {
                                Log.i(TAG, "drinkComponent instanceof FruitInclusion");

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            } else {
                                Log.e(TAG, "drinkComponent NOT instanceof VanillaBeanPowder");
                            }
                        }
                    }
                } else if (key.equals(BlendedOptions.TAG)) {
                    Log.i(TAG, "key.equals(BlendedOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof FrapChips) {
                                Log.i(TAG, "drinkComponent instanceof FrapChips");

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            } else if (drinkComponent instanceof FrapRoast) {
                                Log.i(TAG, "drinkComponent instanceof FrapRoast");

                                int quantityNew = getNumberOfFrapRoastByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            }
                        }
                    }
                } else if (key.equals(EspressoOptions.TAG)) {
                    Log.i(TAG, "key.equals(EspressoOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Shots ||
                                    drinkComponent instanceof ReserveEspressoShots) {
                                Log.i(TAG, "drinkComponent instanceof Shot");

                                int quantityNew = getNumberOfShotByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            }
                        }
                    }
                } else if (key.equals(TeaOptions.TAG)) {
                    Log.i(TAG, "key.equals(TeaOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Chai) {
                                Log.i(TAG, "drinkComponent instanceof Chai");

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            } else if (drinkComponent instanceof MatchaPowder) {
                                Log.i(TAG, "drinkComponent instanceof MatchaPowder");

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            } else if (drinkComponent instanceof TeaBag) {
                                Log.i(TAG, "drinkComponent instanceof TeaBag");

                                int quantityNew = getNumberOfTeaBagByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            }
                        }
                    }
                } else if (key.equals(SweetenerOptions.TAG)) {
                    Log.i(TAG, "key.equals(SweetenerOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Liquid) {
                                Log.i(TAG, "drinkComponent instanceof Liquid");

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);
                            }
                        }
                    }
                } else if (key.equals(FlavorOptions.TAG)) {
                    Log.i(TAG, "key.equals(FlavorOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponentsGroup.get(i);
                        DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Sauce ||
                                    drinkComponent instanceof Syrup ||
                                    drinkComponent instanceof SyrupSeasonal) {
                                Log.i(TAG, "drinkComponent instanceof Sauce || drinkComponent instanceof Syrup || drinkComponent instanceof SyrupSeasonal");

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);
                                if (quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == QUANTITY_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }
                                changedUserCustomizations =
                                        updateQuantityByDrinkSize(drinkComponentWithDefaultAsString, quantityNew);

                            }
                        }
                    }
                } else {
                    Log.e(TAG, "else clause to identify [key] related to drink size changed.");
                }
            }
        }
        return changedUserCustomizations;
    }

    public Map<String, List<DrinkComponentWithDefaultAsString>> getDrinkComponents() {
        return drinkComponents;
    }

    public void setDrinkComponents(Map<String, List<DrinkComponentWithDefaultAsString>> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }

//    public Map<String, List<String>> getDrinkComponentsDefaultAsString() {
//        return drinkComponentsDefaultAsString;
//    }
//
//    public void setDrinkComponentsDefaultAsString(Map<String, List<String>> drinkComponentsDefaultAsString) {
//        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
//    }

    public List<DrinkComponent> getDrinkComponentsStandardRecipe() {
        return drinkComponentsStandardRecipe;
    }

    public void setDrinkComponentsStandardRecipe(List<DrinkComponent> drinkComponentsStandardRecipe) {
        this.drinkComponentsStandardRecipe = drinkComponentsStandardRecipe;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkSize[] getDrinkSizesAllowed() {
        return drinkSizesAllowed;
    }

    public void setDrinkSizesAllowed(DrinkSize[] drinkSizesAllowed) {
        this.drinkSizesAllowed = drinkSizesAllowed;
    }
}
