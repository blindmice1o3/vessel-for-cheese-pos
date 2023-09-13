package com.jackingaming.vesselforcheesepos.models.menu.hierarchy;

import java.util.List;

public class Category extends MenuHierarchyElement {
    public static final String TAG = Category.class.getSimpleName();

    private List<Topic> topics;

    public Category(String name, int idImage,
                    List<Topic> topics) {
        super(name, idImage);
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
