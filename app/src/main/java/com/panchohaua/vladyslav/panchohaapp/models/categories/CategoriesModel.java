package com.panchohaua.vladyslav.panchohaapp.models.categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.panchohaua.vladyslav.panchohaapp.models.Links;
import com.panchohaua.vladyslav.panchohaapp.models.Meta;

import java.util.List;


/**
 * Created by Vladyslav on 20.04.2017.
 */

public class CategoriesModel {


    @SerializedName("items")
    @Expose
    private List<CategoryItem> items = null;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_meta")
    @Expose
    private Meta meta;

    public List<CategoryItem> getItems() {
        return items;
    }

    public void setItems(List<CategoryItem> items) {
        this.items = items;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }



}

