package com.jackingaming.vesselforcheesepos.models.sides;

import com.jackingaming.vesselforcheesepos.models.MenuItem;
import com.jackingaming.vesselforcheesepos.models.sides.customizations.SideCustomization;

import java.util.ArrayList;
import java.util.List;

public abstract class Side extends MenuItem {
    protected List<SideCustomization> customizations = new ArrayList<SideCustomization>();

    public Side() {
        super();
    }

    public Side(String name, String description, double price, boolean handedOff) {
        super(name, description, price, handedOff);
    }

    public List<SideCustomization> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<SideCustomization> customizations) {
        this.customizations = customizations;
    }

    @Override
    public String toString() {
        return "Side{" +
                "customizations=" + customizations +
                '}';
    }
}
