package com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBaseOptions;
import com.jackingaming.vesselforcheesepos.views.viewport.CustomizedDrinkComponentAdapter;

public class SweetenerOptions extends DrinkComponent {
    public static final String TAG = SweetenerOptions.class.getSimpleName();

    public enum Liquid {
        CLASSIC,
        HONEY_BLEND,
        LIQUID_CANE;
    }

    public enum Packet {
        HONEY,
        SPLENDA,
        STEVIA_IN_THE_RAW,
        SUGAR,
        SUGAR_IN_THE_RAW;
    }

    private Liquid liquid;
    private Packet packet;

    public SweetenerOptions(Liquid liquid) {
        this.liquid = liquid;
    }

    public SweetenerOptions(Packet packet) {
        this.packet = packet;
    }

    public Liquid getLiquid() {
        return liquid;
    }

    public Packet getPacket() {
        return packet;
    }

    @NonNull
    @Override
    public String toString() {
        String nameSweetenerOptions = null;
        if (liquid != null) {
            nameSweetenerOptions = Liquid.class.getSimpleName() + ": " + liquid.name();
        } else if (packet != null) {
            nameSweetenerOptions = Packet.class.getSimpleName() + ": " + packet.name();
        } else {
            String errorMessage = SweetenerOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameSweetenerOptions = errorMessage;
        }
        return nameSweetenerOptions;
    }
}
