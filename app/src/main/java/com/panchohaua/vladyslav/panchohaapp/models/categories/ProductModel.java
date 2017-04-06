package com.panchohaua.vladyslav.panchohaapp.models.categories;

import com.panchohaua.vladyslav.panchohaapp.api.APIConfig;
import com.panchohaua.vladyslav.panchohaapp.api.ProductApi;
import com.panchohaua.vladyslav.panchohaapp.models.products.Product;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public class ProductModel {

    private Retrofit retrofit;
    private ProductApi productApi;

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    private String idCategory;

    public ProductModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productApi = retrofit.create(ProductApi.class);
    }

    public void getCategoriesApi(Callback<List<Product>> callback) {
        productApi.getData(APIConfig.key, idCategory).enqueue(callback);
    }

}
