package com.example.android.tourguideapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private static int id = R.id.popular_places_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeView(id);

        //Implement drawer navigation to allow user to click drawer items to move to different activities
        mDrawerLayout = findViewById(R.id.drawer_layout);

        //Set custom toolbar as action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup Menu Button in Action Bar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //Setup onNavigationItemClickListener to open different fragments in response to user selection
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //set item as selected to persist highlight
                item.setChecked(true);
                //close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                //Handle navigation view item clicks here
                id = item.getItemId();

                changeView(id);

                return false;
            }
        });
    }

    public void changeView(int id){
        //Switch to fragment chosen by user in nav drawer
        Fragment fragment;
        switch(id){
            case R.id.popular_places_item:
                fragment = new PopularPlaceFragment();
                break;
            case R.id.hotels_item:
                fragment = new HotelFragment();
                break;
            case R.id.museums_item:
                fragment = new MuseumFragment();
                break;
            case R.id.parks_item:
                fragment = new ParkFragment();
                break;
            case R.id.restaurants_item:
                fragment = new RestaurantFragment();
                break;
            default:
                fragment = new TheaterFragment();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }



    //Open navigation drawer when menu button is selected in actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
