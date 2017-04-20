package com.panchohaua.vladyslav.panchohaapp.presenters;


import android.util.Log;

import com.panchohaua.vladyslav.panchohaapp.fragments.ProductsFragment;
import com.panchohaua.vladyslav.panchohaapp.models.products.ProductAPI;

import com.panchohaua.vladyslav.panchohaapp.models.products.ProductItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public class ProductsPresenter {

    private final ProductAPI productModel;
    private final ProductsFragment productsFragment;


    public ProductsPresenter(final ProductsFragment fragment, String idCategory, String sex) {
        productModel = new ProductAPI(idCategory, sex);
        productsFragment = fragment;
    }

    public void getProducts() {
        productModel.getCategoriesApi(new Callback<List<ProductItem>>() {
            @Override
            public void onResponse(Call<List<ProductItem>> call, Response<List<ProductItem>> response) {
                productsFragment.addList(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductItem>> call, Throwable t) {
                Log.e("PROD", "Error getting products");

            }
        });
    }
}
