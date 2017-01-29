package com.ladse.greasepay.home.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.home.HomePresenter;
import com.ladse.greasepay.home.HomePresenterImpl;
import com.ladse.greasepay.home.HomeView;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.utils.HomePagerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,HomeView {

    private HomePresenter homePresenter;
    private TextView topLabel;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen1);
        View v = findViewById(R.id.setDrawerLayout_mainContent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_screen1_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initializeUI();
        homePresenter=new HomePresenterImpl(this);

    }

    private void initializeUI() {
        topLabel = (TextView) findViewById(R.id.home_toolbar_label);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d");
        String label = "Location, " + sdf.format(new Date());
        topLabel.setText(label);

        tabLayout = (TabLayout) findViewById(R.id.home_screen1_tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab_heading_bars));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab_heading_restaurants));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.home_screen1_viewPager);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //search icon click
        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_my_grease_pay) {

        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_promocode) {

        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_send_feedback) {

        } else if (id == R.id.nav_invite) {

        } else if (id == R.id.nav_faq) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_signOut) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onHomeScreenResponseSuccess(ArrayList<RestaurantData> restaurantData) {

        final HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),restaurantData);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onHomeScreenResponseError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.getRestaurantData(new RestaurantRequest());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onDestroy();
    }
}
