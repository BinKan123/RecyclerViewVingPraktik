package com.example.kanbi.recyclerviewmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main3Activity extends AppCompatActivity {


    TextView titleText;
    TextView textDetails;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        titleText=(TextView) findViewById(R.id.titleText3);
        img=(ImageView) findViewById(R.id.imageView3);
        textDetails=(TextView) findViewById(R.id.textDetails3);

        Intent intent=this.getIntent();
        String title=intent.getExtras().getString("text_key");
        String imageUrl=intent.getExtras().getString("image_key");
        String details=intent.getExtras().getString("details_key");

        //Data binding
        titleText.setText(title);
        textDetails.setText(details);
        Picasso.with(this ).load(imageUrl).into(img);




    }

}
