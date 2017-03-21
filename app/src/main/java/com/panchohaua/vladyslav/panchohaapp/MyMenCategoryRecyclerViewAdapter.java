package com.panchohaua.vladyslav.panchohaapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.panchohaua.vladyslav.panchohaapp.MenCategoryFragment.OnListFragmentInteractionListener;
import com.panchohaua.vladyslav.panchohaapp.models.categories.CategoryItem;

import java.util.List;

public class MyMenCategoryRecyclerViewAdapter extends RecyclerView.Adapter<MyMenCategoryRecyclerViewAdapter.ViewHolder> {

    private final List<CategoryItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyMenCategoryRecyclerViewAdapter(List<CategoryItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_mencategory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
    // в Даному випадку модифікатори доступу  можуть бути відсутні(якщо відстуні значить доступ є лише у класів які знаходяться в цій самій папці,
    // типу відсутній модифікатор називається Local) так як внутрішній клас і юзається лише тут.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public CategoryItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
