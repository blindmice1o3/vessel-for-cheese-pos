package com.jackingaming.vesselforcheesepos.models.menu.hierarchy;

import java.util.List;

public class Topic extends MenuHierarchyElement {
    public static final String TAG = Topic.class.getSimpleName();

    private List<Section> sections;

    public Topic(String name, int idImage,
                 List<Section> sections) {
        super(name, idImage);
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
