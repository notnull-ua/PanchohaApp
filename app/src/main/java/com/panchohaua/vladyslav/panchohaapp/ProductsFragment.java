package com.panchohaua.vladyslav.panchohaapp;

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

import com.panchohaua.vladyslav.panchohaapp.models.products.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vladyslav on 23.03.2017.
 */

public class ProductsFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_ID_CATEGORY = "id-category";

    private int mColumnCount = 2;
    private RecyclerView recyclerView;
    final List<Product> products = new ArrayList<>();

    private ProductsRecyclerViewAdapter productsRecyclerViewAdapter;

    private ProductsPresenter productsPresenter;
    private OnListFragmentInteractionListener mListener;



    public ProductsFragment() {

    }

    @SuppressWarnings("unused")
    public static ProductsFragment newInstance(int columnCount) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressWarnings("unused")
    public static ProductsFragment newInstance(String idCategory) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID_CATEGORY, idCategory);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            if (getArguments().getString(ARG_ID_CATEGORY) != null) {
                productsPresenter = new ProductsPresenter(this);
            }
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            productsRecyclerViewAdapter = new ProductsRecyclerViewAdapter(products, mListener);
            recyclerView.setAdapter(productsRecyclerViewAdapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ProductsFragment.OnListFragmentInteractionListener) {
            mListener = (ProductsFragment.OnListFragmentInteractionListener) context;
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
        void onListFragmentInteraction(Product item);
    }

    public void addList(Collection collection) {
        products.addAll(collection);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
