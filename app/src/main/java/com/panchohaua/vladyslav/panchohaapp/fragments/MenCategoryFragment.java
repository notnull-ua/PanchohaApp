package com.panchohaua.vladyslav.panchohaapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panchohaua.vladyslav.panchohaapp.presenters.MenCategoryPresenter;
import com.panchohaua.vladyslav.panchohaapp.adapters.MyMenCategoryRecyclerViewAdapter;
import com.panchohaua.vladyslav.panchohaapp.OnCategoryFragmentChangeListener;
import com.panchohaua.vladyslav.panchohaapp.R;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MenCategoryFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private OnCategoryFragmentChangeListener mCatFragmentListener;

    final List<CategoryItem> categoryItems = new ArrayList<>();

    private MyMenCategoryRecyclerViewAdapter myMenCategoryRecyclerViewAdapter;

    private RecyclerView recyclerView;

    private MenCategoryPresenter menCategoryPresenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MenCategoryFragment() {
    }

    @SuppressWarnings("unused")
    public static MenCategoryFragment newInstance(int columnCount) {
        MenCategoryFragment fragment = new MenCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menCategoryPresenter.getCategories();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menCategoryPresenter = new MenCategoryPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mencategory_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            myMenCategoryRecyclerViewAdapter = new MyMenCategoryRecyclerViewAdapter(categoryItems, mListener);
            recyclerView.setAdapter(myMenCategoryRecyclerViewAdapter);


            //pagination
            recyclerView.addOnScrollListener(recycleViewOnScrollListener);

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


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(CategoryItem item, String sex);
    }

    public void addList(Collection collection) {
        categoryItems.addAll(collection);
        myMenCategoryRecyclerViewAdapter.notifyDataSetChanged();
    }

    private RecyclerView.OnScrollListener recycleViewOnScrollListener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            menCategoryPresenter.getCategories();


        }
    };

}
