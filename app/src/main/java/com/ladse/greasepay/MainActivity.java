package com.ladse.greasepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.fragments.EditProfile;
import com.ladse.greasepay.fragments.FAQFragment;
import com.ladse.greasepay.fragments.FavoritesFragment;
import com.ladse.greasepay.fragments.MyGreasePayFragment;
import com.ladse.greasepay.fragments.PaymentFragment;
import com.ladse.greasepay.fragments.PromocodeFragment;
import com.ladse.greasepay.fragments.SendFeedbackFragment;
import com.ladse.greasepay.home.HomePresenter;
import com.ladse.greasepay.home.HomePresenterImpl;
import com.ladse.greasepay.home.HomeView;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.utils.HomePagerAdapter;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, HomeView{
    Toolbar toolbar;
    TextView toolbarTitle;
    private FragmentManager fragmentManager;
    private DrawerLayout mDrawerLayout;
    private FragmentTransaction fragmentTransaction;
    private HomePresenter homePresenter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        homePresenter = new HomePresenterImpl(this);
    }
    private void init(){
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        fragmentManager = getSupportFragmentManager();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawerLayout);

        final NavigationView drawer = (NavigationView) findViewById(R.id.activity_main_drawer);

        View headerView = drawer.getHeaderView(0);
        ImageView mDrawerProfilePic = (ImageView) headerView.findViewById(R.id.nav_drawer_profilePic);
        TextView mDrawerName = (TextView) headerView.findViewById(R.id.nav_drawer_profileName);
        //todo set name and profile pic in navigation header

        TextView mDrawerEditProfile = (TextView) headerView.findViewById(R.id.nav_drawer_editProfile);
        mDrawerEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarTitle.setText("Edit Profile");
                EditProfile editProfile = new EditProfile();
                setFragment(editProfile);
            }
        });
        ImageButton menuBtn = (ImageButton) toolbar.findViewById(R.id.activity_main_button_menu);
        toolbarTitle = (TextView) toolbar.findViewById(R.id.activity_main_title);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d");
        String label = "Location, " + sdf.format(new Date());
        drawer.setNavigationItemSelectedListener(this);
        toolbarTitle.setText(label);

        ImageButton mSearchIcon = (ImageButton) toolbar.findViewById(R.id.activity_main_button_search);

        mSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo search icon click event
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.main_screen_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.main_screen_viewPager);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab_heading_bars));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab_heading_restaurants));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_drawer_editProfile:
                toolbarTitle.setText("Edit Profile");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                EditProfile editProfile = new EditProfile();
                setFragment(editProfile);
                break;
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.nav_my_grease_pay:
                toolbarTitle.setText("My Grease Pay");
                MyGreasePayFragment greasePayFragment = new MyGreasePayFragment();
                setFragment(greasePayFragment);
                break;
            case R.id.nav_favorite:
                toolbarTitle.setText("Favorites");
                FavoritesFragment favoritesFragment = new FavoritesFragment();
                setFragment(favoritesFragment);
                break;
            case R.id.nav_promocode:
                toolbarTitle.setText("Promocode");
                PromocodeFragment promocodeFragment = new PromocodeFragment();
                setFragment(promocodeFragment);
                break;
            case R.id.nav_payment:
                toolbarTitle.setText("Payment");
                PaymentFragment paymentFragment = new PaymentFragment();
                setFragment(paymentFragment);
                break;
            case R.id.nav_send_feedback:
                toolbarTitle.setText("Send Feedback");
                SendFeedbackFragment feedbackFragment = new SendFeedbackFragment();
                setFragment(feedbackFragment);
                break;
            case R.id.nav_invite:
                toolbarTitle.setText("Invite");

                break;
            case R.id.nav_faq:
                toolbarTitle.setText("FAQ");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                FAQFragment faqFragment = new FAQFragment();
                faqFragment.setContext(this);
                setFragment(faqFragment);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_signOut:
                logOut(AppSharedPreference.getAuthToken(this));
                break;

        }
        return false;
    }
    private void setFragment(Fragment fragment){
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_fragment_frame, fragment);
            fragmentTransaction.addToBackStack("current");
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawer(GravityCompat.START);
    }



    @Override
    public void onHomeScreenResponseSuccess(ArrayList<RestaurantData> restaurantData) {
        final HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),restaurantData,homePresenter);
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
        AlertManager.showErrorDialog(MainActivity.this,"Server not reachable");
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void logOut(String authToken) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.logoutFromApp(authToken);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(MainActivity.this,response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            if(fragmentManager.getBackStackEntryCount() > 0){
                fragmentManager.popBackStack();
            }
            else{
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                super.onBackPressed();
            }

        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.getRestaurantData(MainActivity.this,new RestaurantRequest());
    }
}
