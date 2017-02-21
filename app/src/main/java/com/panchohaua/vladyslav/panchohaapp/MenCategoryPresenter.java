package com.panchohaua.vladyslav.panchohaapp;

import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;
import com.panchohaua.vladyslav.panchohaapp.models.categories.MenCategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladyslav on 21.02.2017.
 */

public class MenCategoryPresenter {

    private final MenCategoryModel menCategoryModel;
    private final MenCategoryFragment menCategoryFragment;

    public MenCategoryPresenter(final MenCategoryFragment fragment) {
        menCategoryModel = new MenCategoryModel();
        menCategoryFragment = fragment;

        menCategoryModel.getCategoriesApi(new Callback<List<CategoryItem>>() {
            @Override
            public void onResponse(Call<List<CategoryItem>> call, Response<List<CategoryItem>> response) {
                menCategoryFragment.updateList(response.body());
            }

            @Override
            public void onFailure(Call<List<CategoryItem>> call, Throwable t) {

            }
        });
    }


}
