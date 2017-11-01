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
        adapter.addFragment(new JulFragment(),"Jul");

        viewPager.setAdapter(adapter);
    }

}
