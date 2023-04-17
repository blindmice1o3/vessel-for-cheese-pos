package com.jackingaming.vesselforcheesepos.models.menu;

import com.jackingaming.vesselforcheesepos.controllers.input.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.UndefinedDrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.line_the_cup.LineCupWithDrizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.milk_based.lattes.Latte;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.straight_shots.ShotEspresso;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.other.Water;
import com.jackingaming.vesselforcheesepos.models.menu.foods.Bread;
import com.jackingaming.vesselforcheesepos.models.menu.sides.SteamedVegetable;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static final String TAG = Menu.class.getSimpleName();

    public enum Customization {LINE_CUP_WITH_CARAMEL, LINE_CUP_WITH_MOCHA;}

    public enum Category {DRINKS, FOODS, SIDES;}

    public enum CategoryDrinks {BREWED, ESPRESSO, BLENDED, TEA, OTHER;}

    public enum CategoryDrinksBrewed {ICED_COFFEE, COLD_BREW, HOT_COFFEE, MISTO;}

    public enum CategoryDrinksEspresso {SHOT, AMERICANO, CAPPUCCINO, FLAT_WHITE, ICED_SHAKEN_ESPRESSO, LATTE, MACCHIATO;}

    public enum CategoryDrinksEspressoShot {ESPRESSO, ESPRESSO_CON_PANNA;}

    public enum CategoryDrinksEspressoAmericano {AMERICANO;}

    public enum CategoryDrinksEspressoCappuccino {CAPPUCCINO;}

    public enum CategoryDrinksEspressoFlatWhite {FLAT_WHITE, HONEY_ALMONDMILK_FLAT_WHITE;}

    public enum CategoryDrinksEspressoIcedShakenEspresso {ICED_SHAKEN_ESPRESSO, BROWN_SUGAR_OATMILK_SHAKEN_ESPRESSO, CHOCOLATE_ALMONDMILK_SHAKEN_ESPRESSO;}

    public enum CategoryDrinksEspressoLatte {LATTE, CINNAMON_DULCE_LATTE, HONEY_OATMILK_LATTE, MOCHA, WHITE_CHOCOLATE_MOCHA, PUMPKIN_SPICE_LATTE;}

    public enum CategoryDrinksEspressoMacchiato {CARAMEL_MACCHIATO, ESPRESSO_MACCHIATO, APPLE_CRISP_MACCHIATO;}

    public enum CategoryDrinksOther {WATER;}

    public enum CategoryFoods {BREAKFAST, LUNCH, DINNER, OTHER;}

    public enum CategoryFoodsBreakfast {BREAD_BREAKFAST;}

    public enum CategoryFoodsLunch {BREAD_LUNCH;}

    public enum CategoryFoodsDinner {BREAD_DINNER;}

    public enum CategoryFoodsOther {BREAD_OTHER;}

    public enum CategorySides {LOAF, CAKE, DOUGHTNUT, SWEET_ROLL, IMPULSE_ITEM, BROWNIE, COOKIE, BAGEL, CROISSANT, MUFFIN, SCONE, OTHER;}

    public enum CategorySidesOther {STEAMED_VEGETABLE;}

    public static List<String> getListOfAllMilks() {
        List<String> allMilks = new ArrayList<String>();
        for (MilkOptions.MilkBase typeMilk : MilkOptions.MilkBase.values()) {
            allMilks.add(typeMilk.name());
        }

        return allMilks;
    }

    public static List<String> getListOfAllSyrupsAndSauces() {
        List<String> allSyrupsAndSauces = new ArrayList<String>();
        for (FlavorOptions.Syrup syrup : FlavorOptions.Syrup.values()) {
            allSyrupsAndSauces.add(syrup.name());
        }
        for (FlavorOptions.Sauce sauce : FlavorOptions.Sauce.values()) {
            allSyrupsAndSauces.add(sauce.name());
        }

        return allSyrupsAndSauces;
    }

    public static List<String> getListOfAllDrinks() {
        List<String> allDrinks = new ArrayList<String>();
        allDrinks.add(Water.TAG);
        allDrinks.add(ShotEspresso.TAG);
        allDrinks.add(Latte.TAG);

        return allDrinks;
    }

    public static List<String> getListOfAllFoods() {
        List<String> allFoods = new ArrayList<String>();
        allFoods.add(Bread.TAG);

        return allFoods;
    }

    public static List<String> getListOfAllSides() {
        List<String> allSides = new ArrayList<String>();
        allSides.add(SteamedVegetable.TAG);

        return allSides;
    }

    // TODO: instantiateSyrupByButtonTag(String)
    // TODO: instantiateMilkByButtonTag(String)
    // TODO: instantiateCustomizationByButtonTag(String)
    public static DrinkComponent instantiateDrinkComponentByButtonTag(String tagOfSelectedButton) {
        String[] tagSplitted = tagOfSelectedButton.split("\\s+");
        int row = Integer.parseInt(tagSplitted[0]);
        int column = Integer.parseInt(tagSplitted[1]);
        String tagOfFragment = tagSplitted[2];

        DrinkComponent drinkComponentSelected = null;
        if (tagOfFragment.equals(InputPaneFragment.Type.DRINKS_SYRUPS.name())) {
            if (row == 0 && column == 0) {
                drinkComponentSelected = new FlavorOptions();
            } else {
                drinkComponentSelected = new UndefinedDrinkComponent();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.DRINKS_MILKS.name())) {
            if (row == 0 && column == 0) {
                drinkComponentSelected = new MilkOptions();
            } else {
                drinkComponentSelected = new UndefinedDrinkComponent();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.DRINKS_CUSTOMIZATIONS.name())) {
            if (row == 0 && column == 0) {
                drinkComponentSelected = new LineCupWithDrizzle();
            } else {
                drinkComponentSelected = new UndefinedDrinkComponent();
            }
        } else {
            drinkComponentSelected = new UndefinedDrinkComponent();
        }

        return drinkComponentSelected;
    }

    public static MenuItem instantiateMenuItemByButtonTag(String tagOfSelectedButton) {
        String[] tagSplitted = tagOfSelectedButton.split("\\s+");
        int row = Integer.parseInt(tagSplitted[0]);
        int column = Integer.parseInt(tagSplitted[1]);
        String tagOfFragment = tagSplitted[2];

        MenuItem menuItemSelected = null;
        if (tagOfFragment.equals(InputPaneFragment.Type.FOODS.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new Bread();
            } else {
                menuItemSelected = new UndefinedMenuItem();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.DRINKS_HOME.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new Water();
            } else {
                menuItemSelected = new UndefinedMenuItem();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.SIDES.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new SteamedVegetable();
            } else {
                menuItemSelected = new UndefinedMenuItem();
            }
        } else {
            menuItemSelected = new UndefinedMenuItem();
        }

        return menuItemSelected;
    }
}
