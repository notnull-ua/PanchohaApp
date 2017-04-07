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

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
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

        //незрозумілий мені трюк з фрегментом у якому є лише RecyclerView. Але в даному випадку проканає.
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // типу так?
            myMenCategoryRecyclerViewAdapter = new MyMenCategoryRecyclerViewAdapter(categoryItems, mListener);
            recyclerView.setAdapter(myMenCategoryRecyclerViewAdapter);

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

    public void addList(Collection collection) {
        categoryItems.addAll(collection);
        myMenCategoryRecyclerViewAdapter.notifyDataSetChanged();
    }

}
