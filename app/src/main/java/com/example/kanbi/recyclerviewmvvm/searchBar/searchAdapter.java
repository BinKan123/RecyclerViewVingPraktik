package com.example.kanbi.recyclerviewmvvm.searchBar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateAdapter;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 5261 on 2017-11-07.
 */

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder> implements Filterable {

    //interface
    private searchAdapter.OnClickListener onClicklistener;
    public interface OnClickListener {
        void onItemClick(searchModel itemClicked);
    }


    private ArrayList<searchModel> mArrayList;
    private ArrayList<searchModel> mFilteredList;

    public searchAdapter(ArrayList<searchModel> List, searchAdapter.OnClickListener onClicklistener) {
        mArrayList = List;
        mFilteredList = List;
        this.onClicklistener = onClicklistener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView hotelName;
        public TextView hotelType;
        public TextView hotelStar;
        public TextView hotelDetails;



        public ViewHolder(View itemView) {
            super(itemView);

            hotelName=(TextView) itemView.findViewById(R.id.name);
            hotelType=(TextView) itemView.findViewById(R.id.hotelType);
            hotelDetails=(TextView) itemView.findViewById(R.id.details);
            mImageView=(ImageView) itemView.findViewById(R.id.imageHotel);

        }

    }


    @Override
    public searchAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_card, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final searchAdapter.ViewHolder viewHolder, final int i) {
        final searchModel item = mArrayList.get(i);

        searchModel searchResult=mFilteredList.get(i);

        viewHolder.hotelName.setText(item.getHotelName());
        viewHolder.hotelType.setText(item.getHotelType());
        viewHolder.hotelDetails.setText(item.getHotelDetails());

        final Context context = viewHolder.itemView.getContext();

        Picasso.with(context).load(item.getHotelImgURL()).into(viewHolder.mImageView);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClicklistener!=null)
                {
                    onClicklistener.onItemClick(item);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                   // to show a list of earlier keywords
                } else {

                    ArrayList<searchModel> filteredList = new ArrayList<>();

                    for (searchModel search : mArrayList) {

                        if (search.getHotelName().toLowerCase().contains(charString)||(search.getHotelName().toUpperCase().contains(charString) )) {

                            filteredList.add(search);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<searchModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    /*
//another solution for animation of search result list
    public void animateTo(List<searchModel> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    // three helpers to notify the changes on the list
    public searchModel removeItem(int position) {
        final searchModel model = mFilteredList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, searchModel model) {
        mFilteredList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final searchModel model = mFilteredList.remove(fromPosition);
        mFilteredList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    //to remove items in the list
    private void applyAndAnimateRemovals(List<searchModel> newModels) {
        for (int i = mFilteredList.size() - 1; i >= 0; i--) {
            final searchModel model = mFilteredList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    //to add items in the list
    private void applyAndAnimateAdditions(List<searchModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final searchModel model = newModels.get(i);
            if (!mFilteredList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    //to change the position
    private void applyAndAnimateMovedItems(List<searchModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final searchModel model = newModels.get(toPosition);
            final int fromPosition = mFilteredList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

*/




}
