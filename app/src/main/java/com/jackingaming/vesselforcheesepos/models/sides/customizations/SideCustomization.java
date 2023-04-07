package com.jackingaming.vesselforcheesepos.models.sides.customizations;

import com.jackingaming.vesselforcheesepos.models.Customization;

public abstract class SideCustomization extends Customization {
    public SideCustomization() {
    }

    public SideCustomization(String name, double price) {
        super(name, price);
    }
}
