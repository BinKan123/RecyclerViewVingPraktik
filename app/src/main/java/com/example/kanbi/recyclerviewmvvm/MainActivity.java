package com.example.kanbi.recyclerviewmvvm;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kanbi.recyclerviewmvvm.inspirationBooking.InspirationFragment;


public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("VING");
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));




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
    }
}
;