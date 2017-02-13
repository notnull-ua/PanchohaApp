package com.panchohaua.vladyslav.panchohaapp.api;

import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MenCategoriesApi {

    @GET("/v1/categories")
    Call<List<CategoryItem>> getData(@Query("key") String key);

}
