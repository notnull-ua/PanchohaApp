package com.panchohaua.vladyslav.panchohaapp;


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

        productModel.getCategoriesApi(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                productsFragment.addList(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}