package com.example.kanbi.recyclerviewmvvm.searchBar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kanbi.recyclerviewmvvm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 5261 on 2017-11-07.
 */

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.searchViewHolder> {


    private final LayoutInflater mInflater;
    private  List<searchModel> mModels;

    public searchAdapter(Context context, List<searchModel> models) {
        mInflater = LayoutInflater.from(context);
        mModels = new ArrayList<>(models);
    }


    public class searchViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvText;

        public searchViewHolder(View itemView) {
            super(itemView);

            tvText = (TextView) itemView.findViewById(R.id.tvText);
        }

        public void bind(searchModel model) {
            tvText.setText(model.getText());
        }
    }

    @Override
    public searchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.search_item, parent, false);
        return new searchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(searchViewHolder holder, int position) {
        final searchModel model = mModels.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    public void setModels(List<searchModel> models) {
        mModels = new ArrayList<>(models);
    }



}
