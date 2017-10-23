package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.kanbi.recyclerviewmvvm.Adapter;
import com.example.kanbi.recyclerviewmvvm.Data;
import com.example.kanbi.recyclerviewmvvm.Main2Activity;
import com.example.kanbi.recyclerviewmvvm.Main3Activity;
import com.example.kanbi.recyclerviewmvvm.Main4Activity;
import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.kanbi.recyclerviewmvvm.R.id.hotelImage;

/**
 * Created by kanbi on 15/10/2017.
 */

public class hotelAdapter extends RecyclerView.Adapter <hotelAdapter.ViewHolder>{

    //interface
    private ButtonClickListner onClicklistener;
    public interface ButtonClickListner  {
        void btnClick(hotelDataSet itemClicked);
    }

    //adapter
    private final ArrayList<hotelDataSet> hotelData;



    public hotelAdapter(ArrayList<hotelDataSet> hotelData, ButtonClickListner onClicklistener) {
        this.hotelData = hotelData;
        this.onClicklistener = onClicklistener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hotelImage;
        public TextView hotelGroup;
        public TextView hotelType;
        public TextView hotelDetails;

        Button hotelBtn;


        public ViewHolder(View itemView) {
            super(itemView);

            hotelGroup=(TextView) itemView.findViewById(R.id.hotelGroup);
            hotelType=(TextView) itemView.findViewById(R.id.hotelType);
            hotelDetails=(TextView) itemView.findViewById(R.id.hotelDetails);

            hotelImage=(ImageView) itemView.findViewById(R.id.hotelImage);
            hotelBtn=(Button) itemView.findViewById(R.id.hotelBtn);

        }
    }




        @Override
    public hotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final hotelAdapter.ViewHolder holder, final int i) {
        final hotelDataSet item = hotelData.get(i);

        holder.hotelGroup.setText(item.getHotelGroup());
        holder.hotelType.setText(item.getHotelType());
        holder.hotelDetails.setText(item.getHotelDetails());


        final Context context = holder.itemView.getContext();

        Picasso.with(context).load(item.getHotelImgURL()).into(holder.hotelImage);

        holder.hotelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClicklistener!=null)
                {
                    onClicklistener.btnClick(item);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return hotelData.size();
    }





}
