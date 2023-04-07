package com.jackingaming.vesselforcheesepos.models;

import com.jackingaming.vesselforcheesepos.controllers.input.InputPaneFragment;
import com.jackingaming.vesselforcheesepos.models.drinks.other.Water;
import com.jackingaming.vesselforcheesepos.models.drinks.customizations.add_in.LineCupWithCaramel;
import com.jackingaming.vesselforcheesepos.models.foods.Bread;
import com.jackingaming.vesselforcheesepos.models.sides.SteamedVegetable;

public class Menu {
    public static final String[] FOODS = {Bread.NAME_DEFAULT};
    public static final String[] DRINKS = {Water.NAME_DEFAULT};
    public static final String[] SIDES = {SteamedVegetable.NAME_DEFAULT};
    public static final String[] SYRUPS = {DarkCaramelSauce.NAME_DEFAULT};
    public static final String[] MILKS = {TwoPercentMilk.NAME_DEFAULT};
    public static final String[] CUSTOMIZATIONS = {LineCupWithCaramel.NAME_DEFAULT};

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
                menuItemSelected = new Undefined();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.DRINKS.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new Water();
            } else {
                menuItemSelected = new Undefined();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.SIDES.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new SteamedVegetable();
            } else {
                menuItemSelected = new Undefined();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.SYRUPS.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new DarkCaramelSauce();
            } else {
                menuItemSelected = new Undefined();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.MILKS.name())) {
            if (row == 0 && column == 0) {
                menuItemSelected = new TwoPercentMilk();
            } else {
                menuItemSelected = new Undefined();
            }
        } else if (tagOfFragment.equals(InputPaneFragment.Type.CUSTOMIZATIONS.name())) {
            if (row == 0 && column == 0) {
                // TODO: menuItemSelected = new LineCupWithCaramel();
                menuItemSelected = new DarkCaramelSauce();
            } else {
                menuItemSelected = new Undefined();
            }
        } else {
            menuItemSelected = new Undefined();
        }

        return menuItemSelected;
    }
}
