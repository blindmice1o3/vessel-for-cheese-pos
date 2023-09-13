package com.jackingaming.vesselforcheesepos.models.menu.hierarchy;

import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

import java.util.List;

public class Section extends MenuHierarchyElement {
    public static final String TAG = Section.class.getSimpleName();

    private List<MenuItem> menuItems;

    public Section(String name, int idImage,
                   List<MenuItem> menuItems) {
        super(name, idImage);
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
