package com.panchohaua.vladyslav.panchohaapp.models.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public class Variation {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id_product")
    @Expose
    private String idProduct;
    @SerializedName("id_color")
    @Expose
    private String idColor;
    @SerializedName("id_size")
    @Expose
    private String idSize;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("price_sale")
    @Expose
    private Double priceSale;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("src_img")
    @Expose
    private String srcImg;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("available")
    @Expose
    private Long available;
    @SerializedName("valid")
    @Expose
    private Long valid;

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

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdColor() {
        return idColor;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getValid() {
        return valid;
    }

    public void setValid(Long valid) {
        this.valid = valid;
    }

}