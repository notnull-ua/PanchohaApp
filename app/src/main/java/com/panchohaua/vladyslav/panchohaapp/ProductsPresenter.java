package com.panchohaua.vladyslav.panchohaapp;


import android.util.Log;

import com.panchohaua.vladyslav.panchohaapp.models.categories.ProductModel;

import com.panchohaua.vladyslav.panchohaapp.models.products.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public class ProductsPresenter {

    private final ProductModel productModel;
    private final ProductsFragment productsFragment;



    public ProductsPresenter(final ProductsFragment fragment) {
        productModel = new ProductModel();
        productsFragment = fragment;

        if (fragment.getArguments().getString("id-category") != null) {
            productModel.setIdCategory(fragment.getArguments().getString("id-category"));
        }
        productModel.getCategoriesApi(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                productsFragment.addList(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("PROD", "Error getting products");

            }
        });
    }
}
