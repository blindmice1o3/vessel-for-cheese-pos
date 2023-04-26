package com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class TeaOptions extends DrinkComponent {
    public static final String TAG = TeaOptions.class.getSimpleName();

    public enum Chai {
        CHAI;
    }

    public enum IcedTeaBase {
        BLACK_TEA,
        GREEN_TEA,
        PASSION_TANGO_TEA;
    }

    public enum IcedTeaSplash {
        BLACK_TEA,
        GREEN_TEA,
        PASSION_TANGO_TEA;
    }

    public enum MatchaPowder {
        MATCHA_POWDER;
    }

    public enum TeaBag {
        TEA_BAG;
    }

    public enum Extras {
        EXTRA_NONE,
        EXTRA_LEMONADE,
        EXTRA_TEA;
    }

    private Chai chai;
    private IcedTeaBase icedTeaBase;
    private IcedTeaSplash icedTeaSplash;
    private MatchaPowder matchaPowder;
    private TeaBag teaBag;
    private Extras extras;

    public TeaOptions(Chai chai) {
        this.chai = chai;
    }

    public TeaOptions(IcedTeaBase icedTeaBase) {
        this.icedTeaBase = icedTeaBase;
    }

    public TeaOptions(IcedTeaSplash icedTeaSplash) {
        this.icedTeaSplash = icedTeaSplash;
    }

    public TeaOptions(MatchaPowder matchaPowder) {
        this.matchaPowder = matchaPowder;
    }

    public TeaOptions(TeaBag teaBag) {
        this.teaBag = teaBag;
    }

    public TeaOptions(Extras extras) {
        this.extras = extras;
    }

    public IcedTeaBase getIcedTeaBase() {
        return icedTeaBase;
    }

    public IcedTeaSplash getIcedTeaSplash() {
        return icedTeaSplash;
    }

    public MatchaPowder getMatchaPowder() {
        return matchaPowder;
    }

    public TeaBag getTeaBag() {
        return teaBag;
    }

    public Extras getExtras() {
        return extras;
    }

    public Chai getChai() {
        return chai;
    }

    @NonNull
    @Override
    public String toString() {
        String nameTeaOptions = null;
        if (chai != null) {
            nameTeaOptions = Chai.class.getSimpleName() + ": " + chai.name();
        } else if (icedTeaBase != null) {
            nameTeaOptions = IcedTeaBase.class.getSimpleName() + ": " + icedTeaBase.name();
        } else if (icedTeaSplash != null) {
            nameTeaOptions = IcedTeaSplash.class.getSimpleName() + ": " + icedTeaSplash.name();
        } else if (matchaPowder != null) {
            nameTeaOptions = MatchaPowder.class.getSimpleName() + ": " + matchaPowder.name();
        } else if (teaBag != null) {
            nameTeaOptions = TeaBag.class.getSimpleName() + ": " + teaBag.name();
        } else if (extras != null) {
            nameTeaOptions = Extras.class.getSimpleName() + ": " + extras.name();
        } else {
            String errorMessage = TeaOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameTeaOptions = errorMessage;
        }
        return nameTeaOptions;
    }
}
