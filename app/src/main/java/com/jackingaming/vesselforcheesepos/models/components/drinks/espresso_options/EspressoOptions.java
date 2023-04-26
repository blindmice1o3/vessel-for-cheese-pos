package com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class EspressoOptions extends DrinkComponent {
    public static final String TAG = EspressoOptions.class.getSimpleName();

    public enum Shot {
        SHOT
    }

    public enum AffogatoShot {
        AFFOGATO_SHOT;
    }

    public enum RoastOptions {
        NONE,
        BLONDE,
        SIGNATURE,
        DECAF,
        DECAF_ONE_THIRD,
        DECAF_ONE_HALF,
        DECAF_TWO_THIRD;
    }

    public enum PrepOptions {
        NONE,
        UPSIDE_DOWN;
    }

    public enum PullOptions {
        NONE,
        LONG,
        RISTRETTO;
    }

    public enum SizeOptions {
        SOLO,
        DOPPIO,
        TRIPLE,
        QUAD;
    }

    private Shot shot;
    private AffogatoShot affogatoShot;
    private RoastOptions roastOptions;
    private PrepOptions prepOptions;
    private PullOptions pullOptions;
    private SizeOptions sizeOptions;

    public EspressoOptions(Shot shot) {
        this.shot = shot;
    }

    public EspressoOptions(AffogatoShot affogatoShot) {
        this.affogatoShot = affogatoShot;
    }

    public EspressoOptions(RoastOptions roastOptions) {
        this.roastOptions = roastOptions;
    }

    public EspressoOptions(PrepOptions prepOptions) {
        this.prepOptions = prepOptions;
    }

    public EspressoOptions(PullOptions pullOptions) {
        this.pullOptions = pullOptions;
    }

    public EspressoOptions(SizeOptions sizeOptions) {
        this.sizeOptions = sizeOptions;
    }

    public Shot getShot() {
        return shot;
    }

    public AffogatoShot getAffogatoShot() {
        return affogatoShot;
    }

    public RoastOptions getRoastOptions() {
        return roastOptions;
    }

    public PrepOptions getPrepOptions() {
        return prepOptions;
    }

    public PullOptions getPullOptions() {
        return pullOptions;
    }

    public SizeOptions getSizeOptions() {
        return sizeOptions;
    }

    @NonNull
    @Override
    public String toString() {
        String nameEspressoOptions = null;
        if (shot != null) {
            nameEspressoOptions = Shot.class.getSimpleName() + ": " + shot.name();
        } else if (affogatoShot != null) {
            nameEspressoOptions = AffogatoShot.class.getSimpleName() + ": " + affogatoShot.name();
        } else if (roastOptions != null) {
            nameEspressoOptions = RoastOptions.class.getSimpleName() + ": " + roastOptions.name();
        } else if (prepOptions != null) {
            nameEspressoOptions = PrepOptions.class.getSimpleName() + ": " + prepOptions.name();
        } else if (pullOptions != null) {
            nameEspressoOptions = PullOptions.class.getSimpleName() + ": " + pullOptions.name();
        } else if (sizeOptions != null) {
            nameEspressoOptions = SizeOptions.class.getSimpleName() + ": " + sizeOptions.name();
        } else {
            String errorMessage = EspressoOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameEspressoOptions = errorMessage;
        }
        return nameEspressoOptions;
    }
}
