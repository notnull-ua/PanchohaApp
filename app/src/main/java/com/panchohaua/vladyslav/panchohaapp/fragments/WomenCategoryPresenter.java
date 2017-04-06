package com.panchohaua.vladyslav.panchohaapp.fragments;

import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;
import com.panchohaua.vladyslav.panchohaapp.models.categories.WomenCategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WomenCategoryPresenter {

    private final WomenCategoryModel womenCategoryModel;
    private final WomenCategoryFragment womenCategoryFragment;

    public WomenCategoryPresenter(final WomenCategoryFragment fragment) {
        womenCategoryModel = new WomenCategoryModel();
        womenCategoryFragment = fragment;

        womenCategoryModel.getCategoriesApi(new Callback<List<CategoryItem>>() {
            @Override
            public void onResponse(Call<List<CategoryItem>> call, Response<List<CategoryItem>> response) {
                womenCategoryFragment.addList(response.body());
            }

            @Override
            public void onFailure(Call<List<CategoryItem>> call, Throwable t) {


            }
        });
    }


}
