package com.jackingaming.vesselforcheesepos.models.components.drinks.extra_refresher_bases_options;

import com.jackingaming.vesselforcheesepos.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class ExtraRefresherBases extends ExtraRefresherBasesOptions
        implements GranularTwoOptions {
    public static final String DEFAULT_TEXT_INIT = "Add Extra Refresher Bases";
    public static final String ID = "ExtraRefresherBases";

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public Option getOption() {
        return option;
    }

    @Override
    public void setOption(Option option) {
        this.option = option;
    }

    public enum Type {
        NO_WATER_YES_EXTRA_MANGO_DRAGONFRUIT_REFRESHER_BASE,
        NO_WATER_YES_EXTRA_PINEAPPLE_PASSIONFRUIT_REFRESHER_BASE,
        NO_WATER_YES_EXTRA_STRAWBERY_ACAI_REFRESHER_BASE;
    }

    private Type type;
    private Option option;
    private Amount amount = null;

    public ExtraRefresherBases(Type type, Option option) {
        super(ID);

        this.type = type;
        this.option = option;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getTextInit() {
        return (type == null) ? (DEFAULT_TEXT_INIT) : ("Add " + type.name());
    }

    @Override
    public String[] getEnumValuesAsStringArray() {
        Type[] enumValues = Type.values();
        String[] enumValuesAsStringArray = new String[enumValues.length];
        for (int i = 0; i < enumValues.length; i++) {
            enumValuesAsStringArray[i] = enumValues[i].name();
        }
        return enumValuesAsStringArray;
    }

    @Override
    public String getClassAsString() {
        return ExtraRefresherBases.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return (type == null) ? NULL_TYPE_AS_STRING : type.name();
    }

    @Override
    public boolean setTypeByString(String typeAsString) {
        if (typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
            type = null;
            return true;
        }

        Type[] enumValues = Type.values();
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i].name().equals(typeAsString)) {
                type = enumValues[i];
                return true;
            }
        }

        return false;
    }

    @Override
    public DrinkComponent newInstanceViaTypeAsString(String typeAsString, Amount amount) {
        ExtraRefresherBases extraRefresherBases = new ExtraRefresherBases(null, Option.NO_WATER_YES_EXTRA_REFRESHER_BASE);
        extraRefresherBases.setTypeByString(typeAsString);
        return extraRefresherBases;
    }
}
