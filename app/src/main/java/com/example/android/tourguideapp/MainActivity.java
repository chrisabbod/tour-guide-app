package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PopularPlacesFragment())
                .commit();

        //Implement drawer navigation to allow user to click drawer items to move to different activities
        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //set item as selected to persist highlight
                item.setChecked(true);
                //close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                //Handle navigation view item clicks here
                int id = item.getItemId();
                Fragment fragment = null;

                //Switch to fragment chosen by user in nav drawer
                switch(id){
                    case R.id.popular_places_item:
                        fragment = new PopularPlacesFragment();
                        break;
                    case R.id.hotels_item:
                        fragment = new HotelsFragment();
                        break;
                    case R.id.museums_item:
                        fragment = new MuseumsFragment();
                        break;
                    case R.id.parks_item:
                        fragment = new ParksFragment();
                        break;
                    case R.id.restaurants_item:
                        fragment = new RestaurantsFragment();
                        break;
                    default:
                        fragment = new TheatersFragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();

                return false;
            }
        });
    }
}
