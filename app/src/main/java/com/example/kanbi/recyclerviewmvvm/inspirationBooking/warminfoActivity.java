package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.FebFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.AprFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.JanFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.JulFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.JunFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.MayFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.MarFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.SectionPageAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class warminfoActivity extends AppCompatActivity {

    private static final String TAG="warminfoActivity";
    private SectionPageAdapter sectionPageAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warminfo);

        sectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());

        mViewPager=(ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new JanFragment(),"JAN");
        adapter.addFragment(new FebFragment(),"FEB");
        adapter.addFragment(new MarFragment(),"MAR");
        adapter.addFragment(new AprFragment(),"Apr");
        adapter.addFragment(new MayFragment(),"May");
        adapter.addFragment(new JunFragment(),"Jun");
        adapter.addFragment(new JulFragment(),"Nov");

        viewPager.setAdapter(adapter);
        //viewPager.setCurrentItem(3);
        //viewPager.setCurrentItem(Integer.parseInt(indexOf("Jun")));

        /*int position=adapter.getPositionForMonth();

        viewPager.setCurrentItem(Integer.parseInt(String.valueOf(position)));*/

        int monthNo  = Calendar.getInstance().get(Calendar.MONTH);
        if(monthNo>0&& monthNo< 13) {
            viewPager.setCurrentItem(monthNo-3);
        } else {
            // the month number is higher than the number of fragments

        }



        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("MMM");
        Date date=new Date();
        String currentMonth = simpleDateFormat.format(date);



        if ("Jul".equals(currentMonth)) {
            viewPager.setCurrentItem(6);
        }*/

    }


}
