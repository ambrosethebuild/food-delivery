package com.wwdevelopers.fooddelivery.models;

import com.wwdevelopers.fooddelivery.adapters.ItemSizeModel;

import java.io.Serializable;
import java.util.List;

public class ItemModel implements Serializable {


    private String item_id;
    private String name;
    private String price;
    private String description;
    private String picture_url;
    private String category_id;
    private List<ItemSizeModel> itemSizeModelList;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public List<ItemSizeModel> getItemSizeModelList() {
        return itemSizeModelList;
    }

    public void setItemSizeModelList(List<ItemSizeModel> itemSizeModelList) {
        this.itemSizeModelList = itemSizeModelList;
    }


}
