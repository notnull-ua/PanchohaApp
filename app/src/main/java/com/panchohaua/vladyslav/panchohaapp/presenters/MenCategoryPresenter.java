package com.panchohaua.vladyslav.panchohaapp.presenters;

import com.panchohaua.vladyslav.panchohaapp.fragments.MenCategoryFragment;
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
    public int totalPages;
    public int currentPage = 1;

    public MenCategoryPresenter(final MenCategoryFragment fragment) {
        menCategoryModel = new MenCategoryModel();
        menCategoryFragment = fragment;

    }

    private Callback<List<CategoryItem>> listCallback = new Callback<List<CategoryItem>>() {
        @Override
        public void onResponse(Call<List<CategoryItem>> call, Response<List<CategoryItem>> response) {
            totalPages = Integer.parseInt(response.headers().get("X-Pagination-Page-Count"));
            menCategoryFragment.addList(response.body());

        }

        @Override
        public void onFailure(Call<List<CategoryItem>> call, Throwable t) {

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
