package com.panchohaua.vladyslav.panchohaapp.models.categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladyslav on 20.04.2017.
 */

public class CategoriesModel {


    @SerializedName("items")
    @Expose
    private List<CategoryItem> items = null;


    public List<CategoryItem> getItems() {
        return items;
    }

    public void setItems(List<CategoryItem> items) {
        this.items = items;
    }


}

