package com.panchohaua.vladyslav.panchohaapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panchohaua.vladyslav.panchohaapp.adapters.MyWomenCategoryRecyclerViewAdapter;
import com.panchohaua.vladyslav.panchohaapp.R;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;
import com.panchohaua.vladyslav.panchohaapp.presenters.WomenCategoryPresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class WomenCategoryFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 2;
    private OnListFragmentInteractionListener mListener;

    final List<CategoryItem> categoryItems = new ArrayList<>();

    private MyWomenCategoryRecyclerViewAdapter myWomenCategoryRecyclerViewAdapter;

    private RecyclerView recyclerView;

    private WomenCategoryPresenter womenCategoryPresenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WomenCategoryFragment() {
    }

    @SuppressWarnings("unused")
    public static WomenCategoryFragment newInstance(int columnCount) {
        WomenCategoryFragment fragment = new WomenCategoryFragment();
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

        this.womenCategoryPresenter = new WomenCategoryPresenter(this);
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
            myWomenCategoryRecyclerViewAdapter = new MyWomenCategoryRecyclerViewAdapter(categoryItems, mListener);
            recyclerView.setAdapter(myWomenCategoryRecyclerViewAdapter);

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        womenCategoryPresenter.getCategories();
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
        void onListFragmentInteraction(CategoryItem item, String sex);
    }

    public void addList(Collection collection) {
        categoryItems.addAll(collection);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
