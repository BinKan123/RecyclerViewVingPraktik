package com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.hotelAdapter;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.hotelDataSet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 5261 on 2017-10-23.
 */

public class climateAdapter extends RecyclerView.Adapter <climateAdapter.ViewHolder> {


    //interface
    private OnClickListener onClicklistener;
    public interface OnClickListener {
        void onItemClick(climateData itemClicked);
    }


    private ArrayList<climateData> climateData;

    public climateAdapter(ArrayList<climateData> climateData, OnClickListener onClicklistener) {
        this.climateData = climateData;
        this.onClicklistener = onClicklistener;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView destination;
        public TextView soltimmar;
        public TextView vattenTemp;
        public TextView highTemp;
        public TextView lowTemp;

        public ViewHolder(View itemView) {
            super(itemView);

            destination=(TextView) itemView.findViewById(R.id.where);
            soltimmar=(TextView) itemView.findViewById(R.id.sunHr);
            vattenTemp=(TextView) itemView.findViewById(R.id.waterTemp);
            highTemp=(TextView) itemView.findViewById(R.id.highTemp);
            lowTemp=(TextView) itemView.findViewById(R.id.lowTemp);
        }

    }

    @Override
    public climateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item_in_climate,parent,false);

        return new climateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(climateAdapter.ViewHolder holder, int i) {
        final climateData item = climateData.get(i);

        holder.destination.setText(item.getDestination());
        holder.soltimmar.setText(item.getSunHours());
        holder.vattenTemp.setText(item.getWaterTemp());
        holder.highTemp.setText(item.getHeighTemp());
        holder.lowTemp.setText(item.getLowTemp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
        return climateData.size();
    }
}




