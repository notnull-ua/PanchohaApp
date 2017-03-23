package com.panchohaua.vladyslav.panchohaapp.models.products;

/**
 * Created by Vladyslav on 21.03.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id_category")
    @Expose
    private String idCategory;
    @SerializedName("id_brand")
    @Expose
    private String idBrand;
    @SerializedName("id_country")
    @Expose
    private String idCountry;
    @SerializedName("id_season")
    @Expose
    private Long idSeason;
    @SerializedName("id_thickness")
    @Expose
    private Long idThickness;
    @SerializedName("id_sex")
    @Expose
    private String idSex;
    @SerializedName("id_age")
    @Expose
    private String idAge;
    @SerializedName("max_price")
    @Expose
    private Double maxPrice;
    @SerializedName("min_price")
    @Expose
    private Double minPrice;
    @SerializedName("max_price_sale")
    @Expose
    private Double maxPriceSale;
    @SerializedName("min_price_sale")
    @Expose
    private Double minPriceSale;
    @SerializedName("available")
    @Expose
    private Long available;
    @SerializedName("is_new")
    @Expose
    private Long isNew;
    @SerializedName("other_img")
    @Expose
    private String otherImg;
    @SerializedName("percent_discount")
    @Expose
    private Long percentDiscount;
    @SerializedName("id_style")
    @Expose
    private Long idStyle;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("updated_image_at")
    @Expose
    private Object updatedImageAt;
    @SerializedName("popular_index")
    @Expose
    private String popularIndex;
    @SerializedName("variations")
    @Expose
    private List<Variation> variations = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public Long getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Long idSeason) {
        this.idSeason = idSeason;
    }

    public Long getIdThickness() {
        return idThickness;
    }

    public void setIdThickness(Long idThickness) {
        this.idThickness = idThickness;
    }

    public String getIdSex() {
        return idSex;
    }

    public void setIdSex(String idSex) {
        this.idSex = idSex;
    }

    public String getIdAge() {
        return idAge;
    }

    public void setIdAge(String idAge) {
        this.idAge = idAge;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPriceSale() {
        return maxPriceSale;
    }

    public void setMaxPriceSale(Double maxPriceSale) {
        this.maxPriceSale = maxPriceSale;
    }

    public Double getMinPriceSale() {
        return minPriceSale;
    }

    public void setMinPriceSale(Double minPriceSale) {
        this.minPriceSale = minPriceSale;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getIsNew() {
        return isNew;
    }

    public void setIsNew(Long isNew) {
        this.isNew = isNew;
    }

    public String getOtherImg() {
        return otherImg;
    }

    public void setOtherImg(String otherImg) {
        this.otherImg = otherImg;
    }

    public Long getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Long percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Object getUpdatedImageAt() {
        return updatedImageAt;
    }

    public void setUpdatedImageAt(Object updatedImageAt) {
        this.updatedImageAt = updatedImageAt;
    }

    public String getPopularIndex() {
        return popularIndex;
    }

    public void setPopularIndex(String popularIndex) {
        this.popularIndex = popularIndex;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

}
