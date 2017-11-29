package com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 5261 on 2017-10-23.
 */

public class SectionPageAdapter extends FragmentPagerAdapter{

    private final List<Fragment> mfragmentList=new ArrayList<>();
    private final List<String> mFragmentTitleList=new ArrayList<>();

    public void addFragment(Fragment fragment,String title){
        mfragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionPageAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTitleList.get(position);
    }


    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    public  int getPositionForMonth(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("MMM");
        Date date=new Date();
        String currentMonth = simpleDateFormat.format(date);

        int position=mFragmentTitleList.indexOf(currentMonth);

       /*if (position>0){
            return position;

        }*/

        return position;

    }
}
