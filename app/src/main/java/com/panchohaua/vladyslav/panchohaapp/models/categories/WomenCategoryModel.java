package com.panchohaua.vladyslav.panchohaapp.models.categories;

import com.panchohaua.vladyslav.panchohaapp.api.APIConfig;
import com.panchohaua.vladyslav.panchohaapp.api.WomenCategoriesApi;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladyslav on 21.03.2017.
 */

public class WomenCategoryModel {

    private Retrofit retrofit;
    private WomenCategoriesApi womenCategoriesApi;

    public WomenCategoryModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        womenCategoriesApi = retrofit.create(WomenCategoriesApi.class);
    }

    public void getCategoriesApi(Callback<List<CategoryItem>> callback) {
        womenCategoriesApi.getData(APIConfig.key).enqueue(callback);
    }
}
