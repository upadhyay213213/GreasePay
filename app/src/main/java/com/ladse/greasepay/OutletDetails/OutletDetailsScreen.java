package com.ladse.greasepay.OutletDetails;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.OutletDetails.utils.OutletDetailsScreenAdapter;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.squareup.picasso.Picasso;

public class OutletDetailsScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager screenViewPager;
    private TextView mOutletName, mOutletAddress;
    private ImageView mOutletImage;
    private RestaurantData restaurantData;
    private TextView mOutletDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_outlet_details_screen);
        Bundle bundle=getIntent().getBundleExtra(AppConstatnts.BUNDLE);
        restaurantData= (RestaurantData) bundle.getSerializable(AppConstatnts.CLUB_DATA);
        initializeUI(restaurantData);


    }

    private void initializeUI(RestaurantData restaurantData) {
        mOutletName = (TextView) findViewById(R.id.outlet_details_screen_outletName);
        mOutletAddress = (TextView) findViewById(R.id.outlet_details_screen_outletAddress);
        mOutletDistance= (TextView) findViewById(R.id.outlet_details_screen_outletDistance);
        mOutletImage = (ImageView) findViewById(R.id.outlet_details_screen_outletImage);
        setOutletDetails(restaurantData);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.home_screen1_toolbar);
        setSupportActionBar(myToolbar);

        DrawerLayout navDrawer = (DrawerLayout) findViewById(R.id.outlet_details_screen_drawer);
        ActionBarDrawerToggle abdToggle = new
                ActionBarDrawerToggle(this, navDrawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navDrawer.setDrawerListener(abdToggle);
        abdToggle.syncState();

        NavigationView navView = (NavigationView) findViewById(R.id.outlet_details_screen_nav_view);
        navView.setNavigationItemSelectedListener(this);

        TabLayout screenTabLayout = (TabLayout) findViewById(R.id.outlet_details_screen_tab);
        screenViewPager = (ViewPager) findViewById(R.id.outlet_details_screen_viewPager);

        screenTabLayout.addTab(screenTabLayout.newTab().setText(R.string.outlet_details_tab_heading_greasepay));
        screenTabLayout.addTab(screenTabLayout.newTab().setText(R.string.outlet_details_tab_heading_events));
        screenTabLayout.addTab(screenTabLayout.newTab().setText(R.string.outlet_details_tab_about));
        screenTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        OutletDetailsScreenAdapter odsAdapter = new OutletDetailsScreenAdapter(getSupportFragmentManager(), screenTabLayout.getTabCount(),restaurantData);
        screenViewPager.setAdapter(odsAdapter);

        screenViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(screenTabLayout));
        screenTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                screenViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setOutletDetails(RestaurantData restaurantData) {
        Picasso.with(this).load(restaurantData.getImageUrl()).into(mOutletImage);
        mOutletAddress.setText(restaurantData.getAddress());
        mOutletName.setText(restaurantData.getName());

        //todo set  outlet name, address and image

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
