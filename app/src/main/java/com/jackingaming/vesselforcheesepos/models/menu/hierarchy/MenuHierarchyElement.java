package com.jackingaming.vesselforcheesepos.models.menu.hierarchy;

import java.io.Serializable;

public abstract class MenuHierarchyElement
        implements Serializable {
    private String name;
    private int idImage;

    public MenuHierarchyElement(String name, int idImage) {
        this.name = name;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
