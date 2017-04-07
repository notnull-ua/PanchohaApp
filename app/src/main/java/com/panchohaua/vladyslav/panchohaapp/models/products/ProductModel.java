package com.panchohaua.vladyslav.panchohaapp.models.products;

import com.panchohaua.vladyslav.panchohaapp.api.APIConfig;
import com.panchohaua.vladyslav.panchohaapp.api.ProductApi;

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
    private String idCategory;
    private String sex;

    public ProductModel(String idCategory, String sex) {
        this.idCategory = idCategory;
        this.sex = sex;
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productApi = retrofit.create(ProductApi.class);

    }

    public ProductModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productApi = retrofit.create(ProductApi.class);
    }

    public void getCategoriesApi(Callback<List<Product>> callback) {
        if (idCategory != null && sex != null) {
            productApi.getData(APIConfig.key, idCategory, sex).enqueue(callback);
        } else if (idCategory != null) {
            productApi.getData(APIConfig.key, idCategory).enqueue(callback);
        }

    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
