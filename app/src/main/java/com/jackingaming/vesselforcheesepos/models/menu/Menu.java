package com.jackingaming.vesselforcheesepos.models.menu;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.controllers.input.second_level.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.UndefinedDrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBaseOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
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

    // TODO: instantiateSyrupByButtonTag(String)
    // TODO: instantiateMilkByButtonTag(String)
    // TODO: instantiateCustomizationByButtonTag(String)
    public static DrinkComponent instantiateDrinkComponentByButtonTag(String tagOfSelectedButton) {
        DrinkComponent drinkComponentSelected = null;
        // FlavorOptions.Syrup
        if (tagOfSelectedButton.equals(FlavorOptions.Syrup.BROWN_SUGAR.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.BROWN_SUGAR);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.CARAMEL.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.CARAMEL);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.CINNAMON_DOLCE.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.CINNAMON_DOLCE);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.HAZELNUT.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.HAZELNUT);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.PEPPERMINT.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.PEPPERMINT);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.RASPBERRY.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.RASPBERRY);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.SUGAR_FREE_VANILLA.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.SUGAR_FREE_VANILLA);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.TOASTED_VANILLA.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.TOASTED_VANILLA);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.TOFFEE_NUT.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.TOFFEE_NUT);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.VANILLA.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.VANILLA);
        }
        // FlavorOptions.Sauce
        else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.DARK_CARAMEL.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.DARK_CARAMEL);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.MOCHA.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.MOCHA);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.PISTACHIO.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.PISTACHIO);
        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA.name())) {
            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA);
        }
        // SweetenerOptions.Liquid
        else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.CLASSIC.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.CLASSIC);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.HONEY_BLEND.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.HONEY_BLEND);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.LIQUID_CANE.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.LIQUID_CANE);
        }
        // TeaOptions.Chai
        else if (tagOfSelectedButton.equals(TeaOptions.Chai.CHAI.name())) {
            drinkComponentSelected = new TeaOptions(TeaOptions.Chai.CHAI);
        }
        // MilkOptions.MilkBase
        else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.TWO_PERCENT.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.TWO_PERCENT);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.BREVE.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.BREVE);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.COCONUT.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.COCONUT);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.HEAVY_CREAM.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.HEAVY_CREAM);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.NONFAT_MILK.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.NONFAT_MILK);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.OATMILK.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.OATMILK);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.SOY.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.SOY);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.VANILLA_SWEET_CREAM.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.VANILLA_SWEET_CREAM);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.WHOLE_MILK.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.WHOLE_MILK);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.ALMOND.name())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.ALMOND);
        }
        // CUSTOMIZATIONS
        else if (tagOfSelectedButton.equals(AddInsOptions.Ice.class.getSimpleName())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Ice.MEDIUM);
        } else if (tagOfSelectedButton.equals(AddInsOptions.Water.class.getSimpleName())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Water.MEDIUM);
        } else if (tagOfSelectedButton.equals(ToppingOptions.WhippedCream.class.getSimpleName())) {
            drinkComponentSelected = new ToppingOptions(ToppingOptions.WhippedCream.WHIPPED_CREAM);
        } else if (tagOfSelectedButton.equals(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SPLENDA.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SPLENDA);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SUGAR.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SUGAR);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.STEVIA_IN_THE_RAW.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.STEVIA_IN_THE_RAW);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.HONEY.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.HONEY);
        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SUGAR_IN_THE_RAW.name())) {
            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SUGAR_IN_THE_RAW);
        } else if (tagOfSelectedButton.equals(AddInsOptions.Fruit.STRAWBERRY_PUREE.name())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Fruit.STRAWBERRY_PUREE);
        } else if (tagOfSelectedButton.equals(BlendedOptions.FrapChips.FRAP_CHIPS.name())) {
            drinkComponentSelected = new BlendedOptions(BlendedOptions.FrapChips.FRAP_CHIPS);
        } else if (tagOfSelectedButton.equals(AddInsOptions.Powder.VANILLA_BEAN.name())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Powder.VANILLA_BEAN);
        } else if (tagOfSelectedButton.equals(TeaOptions.MatchaPowder.MATCHA_POWDER.name())) {
            drinkComponentSelected = new TeaOptions(TeaOptions.MatchaPowder.MATCHA_POWDER);
        } else if (tagOfSelectedButton.equals(AddInsOptions.Powder.CHOCOLATE_MALT.name())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Powder.CHOCOLATE_MALT);
        } else if (tagOfSelectedButton.equals("Mocha_Drizzle")) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.LineTheCup.MOCHA_SAUCE);
        } else if (tagOfSelectedButton.equals("Caramel_Drizzle")) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.LineTheCup.CARAMEL_SAUCE);
        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.BLACK_TEA.name())) {
            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.BLACK_TEA);
        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.GREEN_TEA.name())) {
            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.GREEN_TEA);
        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA.name())) {
            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA);
        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT.name())) {
            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT);
        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI.name())) {
            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI);
        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT.name())) {
            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT);
        } else if (tagOfSelectedButton.equals(MilkOptions.MilkFoam.class.getSimpleName())) {
            drinkComponentSelected = new MilkOptions(MilkOptions.MilkFoam.MEDIUM);
        } else if (tagOfSelectedButton.equals(AddInsOptions.Room.class.getSimpleName())) {
            drinkComponentSelected = new AddInsOptions(AddInsOptions.Room.MEDIUM);
        } else if (tagOfSelectedButton.equals(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM.name())) {
            drinkComponentSelected = new ToppingOptions(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM);
        } else if (tagOfSelectedButton.equals(JuiceOptions.Juice.PEACH_BLEND.name())) {
            drinkComponentSelected = new JuiceOptions(JuiceOptions.Juice.PEACH_BLEND);
        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT.name())) {
            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT);
        } else if (tagOfSelectedButton.equals(LemonadeOptions.Lemonade.LEMONADE.name())) {
            drinkComponentSelected = new LemonadeOptions(LemonadeOptions.Lemonade.LEMONADE);
        } else if (tagOfSelectedButton.equals(JuiceOptions.Juice.APPLE.name())) {
            drinkComponentSelected = new JuiceOptions(JuiceOptions.Juice.APPLE);
        }
        // UNDEFINED
        else {
            drinkComponentSelected = new UndefinedDrinkComponent();
        }

        return drinkComponentSelected;
    }

    public static MenuItem instantiateMenuItemByButtonTag(String tagOfSelectedButton) {
        MenuItem menuItemSelected = null;
        // FOODS
        if (tagOfSelectedButton.equals(Bread.NAME_DEFAULT)) {
            menuItemSelected = new Bread();
        }
        // DRINKS
        else if (tagOfSelectedButton.equals(Water.NAME_DEFAULT)) {
            menuItemSelected = new Water();
        }
        // SIDES
        else if (tagOfSelectedButton.equals(SteamedVegetable.NAME_DEFAULT)) {
            menuItemSelected = new SteamedVegetable();
        }
        // UNDEFINED
        else {
            menuItemSelected = new UndefinedMenuItem();
        }

        return menuItemSelected;
    }

    public static List<String> createListOfButtonTitleFoods() {
        List<String> allFoods = new ArrayList<String>();

        allFoods.add(Bread.NAME_DEFAULT);
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        return allFoods;
    }

    public static List<String> createListOfButtonTitleDrinks() {
        List<String> allDrinks = new ArrayList<String>();

        allDrinks.add(Water.NAME_DEFAULT);
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        return allDrinks;
    }

    public static List<String> createListOfButtonTitleSides() {
        List<String> allSides = new ArrayList<String>();

        allSides.add(SteamedVegetable.NAME_DEFAULT);
        allSides.add("NULL");
        allSides.add("NULL");

        allSides.add("NULL");
        allSides.add("NULL");
        allSides.add("NULL");

        return allSides;
    }

    public static List<String> createListOfButtonTitleFlavors() {
        List<String> allFlavors = new ArrayList<String>();

        allFlavors.add(FlavorOptions.Syrup.CARAMEL.name());
        allFlavors.add(FlavorOptions.Syrup.CINNAMON_DOLCE.name());
        allFlavors.add(FlavorOptions.Syrup.HAZELNUT.name());
        allFlavors.add(FlavorOptions.Syrup.TOFFEE_NUT.name());
        allFlavors.add(FlavorOptions.Syrup.VANILLA.name());

        allFlavors.add(SweetenerOptions.Liquid.CLASSIC.name());
        allFlavors.add(FlavorOptions.Syrup.PEPPERMINT.name());
        allFlavors.add(FlavorOptions.Syrup.RASPBERRY.name());
        allFlavors.add(FlavorOptions.Syrup.TOASTED_VANILLA.name());
        allFlavors.add(FlavorOptions.Syrup.BROWN_SUGAR.name());

        allFlavors.add(TeaOptions.Chai.CHAI.name());
        allFlavors.add(SweetenerOptions.Liquid.HONEY_BLEND.name());
        allFlavors.add(SweetenerOptions.Liquid.LIQUID_CANE.name());
        allFlavors.add("NULL");
        allFlavors.add("NULL");

        allFlavors.add(FlavorOptions.Syrup.SUGAR_FREE_VANILLA.name());
        allFlavors.add("NULL");
        allFlavors.add("NULL");
        allFlavors.add("NULL");
        allFlavors.add("NULL");

        allFlavors.add(FlavorOptions.Sauce.MOCHA.name());
        allFlavors.add(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA.name());
        allFlavors.add(FlavorOptions.Sauce.DARK_CARAMEL.name());
        allFlavors.add("NULL");
        allFlavors.add("NULL");

        allFlavors.add(FlavorOptions.Sauce.PISTACHIO.name());
        allFlavors.add("NULL");
        allFlavors.add("NULL");
        allFlavors.add("NULL");
        allFlavors.add("More_Seasonal_Syrup");

        return allFlavors;
    }

    public static List<String> createListOfButtonTitleMilkCreamers() {
        List<String> allCreamers = new ArrayList<String>();

        allCreamers.add(AddInsOptions.MilkCreamer.NONFAT_MILK.name());
        allCreamers.add(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name());
        allCreamers.add(AddInsOptions.MilkCreamer.TWO_PERCENT.name());
        allCreamers.add(AddInsOptions.MilkCreamer.WHOLE_MILK.name());
        allCreamers.add(AddInsOptions.MilkCreamer.SOY.name());
        allCreamers.add(AddInsOptions.MilkCreamer.OATMILK.name());
        allCreamers.add(AddInsOptions.MilkCreamer.COCONUT.name());
        allCreamers.add(AddInsOptions.MilkCreamer.ALMOND.name());
        allCreamers.add(AddInsOptions.MilkCreamer.BREVE.name());
        allCreamers.add(AddInsOptions.MilkCreamer.HEAVY_CREAM.name());

        return allCreamers;
    }

    public static List<String> createListOfButtonTitleMilkBases() {
        List<String> allMilks = new ArrayList<String>();

        allMilks.add(MilkOptions.MilkBase.NONFAT_MILK.name());
        allMilks.add(MilkOptions.MilkBase.VANILLA_SWEET_CREAM.name());
        allMilks.add(MilkOptions.MilkBase.TWO_PERCENT.name());
        allMilks.add(MilkOptions.MilkBase.WHOLE_MILK.name());
        allMilks.add(MilkOptions.MilkBase.SOY.name());
        allMilks.add(MilkOptions.MilkBase.OATMILK.name());
        allMilks.add(MilkOptions.MilkBase.COCONUT.name());
        allMilks.add(MilkOptions.MilkBase.ALMOND.name());
        allMilks.add(MilkOptions.MilkBase.BREVE.name());
        allMilks.add(MilkOptions.MilkBase.HEAVY_CREAM.name());

        return allMilks;
    }

    public static List<String> createListOfButtonTitleCustomizations() {
        List<String> allCustomizations = new ArrayList<String>();

        allCustomizations.add(AddInsOptions.Ice.class.getSimpleName());
        allCustomizations.add(AddInsOptions.Water.class.getSimpleName());
        allCustomizations.add(ToppingOptions.WhippedCream.class.getSimpleName());
        allCustomizations.add(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name());
        allCustomizations.add("NULL");
        allCustomizations.add("NULL");

        allCustomizations.add("Agave"); // TODO: suppose to be in FOODS-oatmeal.
        allCustomizations.add(SweetenerOptions.Packet.SPLENDA.name());
        allCustomizations.add(SweetenerOptions.Packet.SUGAR.name());
        allCustomizations.add(SweetenerOptions.Packet.STEVIA_IN_THE_RAW.name());
        allCustomizations.add(SweetenerOptions.Packet.HONEY.name());
        allCustomizations.add(SweetenerOptions.Packet.SUGAR_IN_THE_RAW.name());

        allCustomizations.add("Banana"); // TODO: suppose to be in FOODS-discontinued.
        allCustomizations.add(AddInsOptions.Fruit.STRAWBERRY_PUREE.name());
        allCustomizations.add(BlendedOptions.FrapChips.FRAP_CHIPS.name());
        allCustomizations.add(AddInsOptions.Powder.VANILLA_BEAN.name());
        allCustomizations.add(TeaOptions.MatchaPowder.MATCHA_POWDER.name());
        allCustomizations.add(AddInsOptions.Powder.CHOCOLATE_MALT.name());

        allCustomizations.add("Mocha_Drizzle");
        allCustomizations.add("Caramel_Drizzle");
        allCustomizations.add("No_topping");
        allCustomizations.add("Coconut_Flakes");
        allCustomizations.add("Add_Blueberries"); // TODO: suppose to be in FOODS-oatmeal.
        allCustomizations.add("Strawberry_Drizzle");

        allCustomizations.add(TeaOptions.IcedTeaSplash.BLACK_TEA.name());
        allCustomizations.add(TeaOptions.IcedTeaSplash.GREEN_TEA.name());
        allCustomizations.add(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA.name());
        allCustomizations.add(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT.name());
        allCustomizations.add(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI.name());
        allCustomizations.add(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT.name());

        allCustomizations.add(MilkOptions.MilkFoam.class.getSimpleName());
        allCustomizations.add(AddInsOptions.Room.class.getSimpleName());
        allCustomizations.add(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM.name());
        allCustomizations.add(JuiceOptions.Juice.PEACH_BLEND.name());
        allCustomizations.add(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT.name());
        allCustomizations.add(LemonadeOptions.Lemonade.LEMONADE.name());

        allCustomizations.add("Extra_Hot");
        allCustomizations.add("Warm");
        allCustomizations.add("Temperature");
        allCustomizations.add(JuiceOptions.Juice.APPLE.name());
        allCustomizations.add("More_Custom_Toppings_and_Inclusions");
        allCustomizations.add("More_Custom_Directions");

        return allCustomizations;
    }
}
