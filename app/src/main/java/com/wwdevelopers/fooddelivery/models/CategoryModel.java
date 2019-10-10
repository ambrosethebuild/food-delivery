package com.wwdevelopers.fooddelivery.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {

    private String category_id;
    private String name;
    private boolean selected;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}
