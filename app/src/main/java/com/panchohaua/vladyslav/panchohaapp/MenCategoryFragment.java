package com.panchohaua.vladyslav.panchohaapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panchohaua.vladyslav.panchohaapp.api.MenCategoriesApi;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MenCategoryFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    final List<CategoryItem> categoryItems = new ArrayList<>();

    private MyMenCategoryRecyclerViewAdapter myMenCategoryRecyclerViewAdapter ;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MenCategoryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MenCategoryFragment newInstance(int columnCount) {
        MenCategoryFragment fragment = new MenCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mencategory_list, container, false);

        //незрозумілий мені трюк з фрегментом у якому є лише RecyclerView. Але в даному випадку проканає.
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // типу так?
            myMenCategoryRecyclerViewAdapter = new MyMenCategoryRecyclerViewAdapter(categoryItems, mListener);
            recyclerView.setAdapter(myMenCategoryRecyclerViewAdapter);
            // Ці речі робляться в окремих класах... Фрагмент по факту являється вью контроллером. Тут повинні тільи бути речі пов'язані з вью
            // Щоб уникнути такої ситуації треба створити клас Модель (MenCategoryModel), в якому буде запит на отримання даних. по факту у модель можна передати калбек
            // типу в моделі щоб був метод public void getCategoriesApi(Callback<List<CategoryItem>> someCallback){  menCategoriesApi.getData("1").enqueue(someCallback);}
            // Щоб не сворювати ретрофітовські калбеки в цьому класі створи проміжний клас типу презентера. Який буже спілкуватись з моделями і буде лінк на Вью. Ініцілізуєш
            // презентер у методі онКріейт в фрагменті і передаєш туди this що = ссилка на твій фрагмент. А потім якщо хочеш змінити щось в фрагменті то викликай публічні методи цього фрагменту.
            // так як лінк на фрегмент в тебе є ти можеш це робити без проблем.
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://admin.panchoha-ua.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MenCategoriesApi menCategoriesApi = retrofit.create(MenCategoriesApi.class);
            menCategoriesApi.getData("1").enqueue(new Callback<List<CategoryItem>>() {
                @Override
                public void onResponse(Call<List<CategoryItem>> call, Response<List<CategoryItem>> response) {
                    categoryItems.addAll(response.body());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<CategoryItem>> call, Throwable t) {

                }
            });


        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(CategoryItem item);
    }
}
