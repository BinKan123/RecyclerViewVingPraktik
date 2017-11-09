package com.example.kanbi.recyclerviewmvvm;


import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kanbi.recyclerviewmvvm.searchBar.searchFilterActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanbi on 04/10/2017.
 */

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder>{
    public Context context;

   // String[] items;
    private ArrayList<Data> mDataSet;


    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(ArrayList<Data> myDataset, Context context) {
        this.mDataSet = myDataset;
        this.context = context;

    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int i) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.eachitem, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(row);
        return vh;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView;
        public TextView mTextDetails;
        public ImageView mImageView;


        public ViewHolder(View viewItem){
            super(viewItem);
            viewItem.setClickable(true);
            viewItem.setOnClickListener(this);
            context=viewItem.getContext();

            mTextView=(TextView) viewItem.findViewById(R.id.text);
            mImageView=(ImageView) viewItem.findViewById(R.id.image);
            mTextDetails=(TextView) viewItem.findViewById(R.id.textDetails);

        }

        @Override
        public void onClick(View v) {
            final Intent intent;

            switch (getAdapterPosition()){
                case 0:
                intent=new Intent(context, Main2Activity.class);
                    intent.putExtra("text_key", mDataSet.get(0).getText());
                    intent.putExtra("image_key",mDataSet.get(0).getImageURL());
                    intent.putExtra("details_key",mDataSet.get(0).getDetails());

                    //ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(getAdapterPosition(),v.findViewById(R.id.image),"myTestImage");
                break;

                case 1:
                    intent=new Intent(context, Main3Activity.class);
                    intent.putExtra("text_key", mDataSet.get(1).getText());
                    intent.putExtra("image_key",mDataSet.get(1).getImageURL());
                    intent.putExtra("details_key",mDataSet.get(1).getDetails());

                    //Toast.makeText(context,"The Item Clicked is" + getAdapterPosition(),Toast.LENGTH_SHORT).show();
                break;

                case 2:
                    intent=new Intent(context, searchFilterActivity.class);
                    break;

                default:
                    intent=new Intent(context,Main4Activity.class);
                    break;

            }
            context.startActivity(intent);


        }



    }




    @Override
    public void onBindViewHolder(ViewHolder holder,int i){
        holder.mTextView.setText(mDataSet.get(i).getText());

     Picasso.with(context).load(mDataSet.get(i).getImageURL()).into(holder.mImageView);

    }



    @Override
    public int getItemCount() {
        return mDataSet.size();
    }





    }

