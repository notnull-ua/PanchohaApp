package com.panchohaua.vladyslav.panchohaapp.api;

import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vladyslav on 03.02.2017.
 */

public interface MenCategoriesApi {

    @GET("/v1/categories/for-men")
    /* KEY is the parameter in GET query, means key = access token   */
    Call<List<CategoryItem>> getData(@Query("key") String key);

}
