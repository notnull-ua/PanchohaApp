package com.panchohaua.vladyslav.panchohaapp.models.categories;

import com.panchohaua.vladyslav.panchohaapp.api.APIConfig;
import com.panchohaua.vladyslav.panchohaapp.api.MenCategoriesApi;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladyslav on 20.02.2017.
 */

public class MenCategoryModel {
    private Retrofit retrofit;
    private MenCategoriesApi menCategoriesApi;

    public MenCategoryModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        menCategoriesApi = retrofit.create(MenCategoriesApi.class);
    }

    public void getCategoriesApi(Callback<List<CategoryItem>> callback) {
        menCategoriesApi.getData(APIConfig.key).enqueue(callback);
    }

    public void getCategoriesApi(Callback<List<CategoryItem>> callback, int page) {
        menCategoriesApi.getData(APIConfig.key, page).enqueue(callback);
    }
}


