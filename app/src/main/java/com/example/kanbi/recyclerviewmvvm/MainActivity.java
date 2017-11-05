package com.example.kanbi.recyclerviewmvvm;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kanbi.recyclerviewmvvm.bokaResa.BokaResaFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.InspirationFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.FebFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.JanFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.MarFragment;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.SectionPageAdapter;
import com.example.kanbi.recyclerviewmvvm.minSida.MinSidaFragment;
import com.example.kanbi.recyclerviewmvvm.sistaMinuten.SistaMinFragment;


public class MainActivity extends AppCompatActivity {

    //one way to make navigation with FramentTransaction
   /* private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;*/


    private NavPageAdapter navPageAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("VING");
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbartop);


        //use viewpager to create navigationbar

        mViewPager = (ViewPager) findViewById(R.id.container);
         tabLayout = (TabLayout) findViewById(R.id.tabs);

        navPageAdapter = new NavPageAdapter(getSupportFragmentManager());

        setupViewPager(mViewPager);

        tabLayout.setupWithViewPager(mViewPager);

        createTabIcons();



    }

    //actionbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_myacc:
                Toast.makeText(MainActivity.this,"myAccount",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //viewpager

    private void setupViewPager(ViewPager viewPager){
        NavPageAdapter adapter=new NavPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new StartFragment(),"Start");
        adapter.addFragment(new SistaMinFragment(),"Sista minut");
        adapter.addFragment(new BokaResaFragment(),"Boka resa");
        adapter.addFragment(new InspirationFragment(),"Inspiration");
        adapter.addFragment(new MinSidaFragment(),"Min sida");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
    }

    //icon on tabs
    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_icon, null);
        tabOne.setText("Start");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.start, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_icon, null);
        tabTwo.setText("Sista minut");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lastmin, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_icon, null);
        tabThree.setText("Boka resa");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.book, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_icon, null);
        tabFour.setText("Inspiration");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.globe, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_icon, null);
        tabFive.setText("Min sida");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.minsida, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabFive);
    }



        /*  use FragmentTransaction to make navigationbar
        //Navigation Fragment

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.menu_main);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.start:
                        fragment = new StartFragment();
                        break;
                    case R.id.lastMin:
                        fragment = new SistaMinFragment();
                        break;
                    case R.id.bokaResa:
                        fragment = new BokaResaFragment();
                        break;
                    case R.id.inspiration:
                        fragment = new InspirationFragment();
                        break;
                    case R.id.minSida:
                        fragment = new MinSidaFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                transaction.replace(R.id.content_holder, fragment).commit();
                return true;
            }
        });

        //to ensure new StartFragment() shows up by default
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_holder, new StartFragment()).commit();


    }


    //toolbar icon
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id=item.getItemId();
        if (res_id==R.id.action_myacc){
            Toast.makeText(getApplicationContext(),"selected my account", Toast.LENGTH_SHORT).show();

        }
        if (res_id==R.id.action_search){
            Toast.makeText(getApplicationContext(),"selected search", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }*/
}
;