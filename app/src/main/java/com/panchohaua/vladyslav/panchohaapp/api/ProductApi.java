package com.panchohaua.vladyslav.panchohaapp.api;


import com.panchohaua.vladyslav.panchohaapp.models.products.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public interface ProductApi {

    @GET("/v1/products")
    /* KEY is the parameter in GET query, means key = access token   */
    Call<List<Product>> getData(@Query("key") String key);

    @GET("/v1/products")
    Call<List<Product>> getData(@Query("key") String key, @Query("category[]") String category);

    @GET("/v1/products")
    Call<List<Product>> getData(@Query("key") String key, @Query("category[]") String category, @Query("type") String type);
    //@GET("/v1/products")
    // Call<List<Product>> getData(@Query("key") String key, @Query("category[]") String category, @Query("sex") String sex,@Query("age") S);

    @GET("/v1/products/{id}")
    Call<List<Product>> getItem(@Query("key") String key, @Query("id") String id);

}
