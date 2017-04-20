package com.panchohaua.vladyslav.panchohaapp.presenters;

import android.util.Log;

import com.panchohaua.vladyslav.panchohaapp.fragments.MenCategoryFragment;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoriesModel;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;
import com.panchohaua.vladyslav.panchohaapp.models.categories.MenCategoryAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vladyslav on 21.02.2017.
 */

public class MenCategoryPresenter {

    private final MenCategoryAPI menCategoryModel;
    private final MenCategoryFragment menCategoryFragment;
    public int totalPages;
    public int currentPage = 1;

    public MenCategoryPresenter(final MenCategoryFragment fragment) {
        menCategoryModel = new MenCategoryAPI();
        menCategoryFragment = fragment;

    }

    private Callback<CategoriesModel> listCallback = new Callback<CategoriesModel>() {
        @Override
        public void onResponse(Call<CategoriesModel> call, Response<CategoriesModel> response) {

            CategoriesModel categoriesModel = response.body();
            Log.d("TaG", "callback");
            //menCategoryFragment.addList(response.body());
        }

        @Override
        public void onFailure(Call<CategoriesModel> call, Throwable t) {
            Log.d("TaG", t.getMessage());
        }
    };

    public void getCategories() {
        if (currentPage == 1) {
            menCategoryModel.getCategoriesApi(listCallback);
            currentPage++;
        } else if (currentPage < totalPages) {
            menCategoryModel.getCategoriesApi(listCallback, currentPage);
            currentPage++;
        }

    }


}
