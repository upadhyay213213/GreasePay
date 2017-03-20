package com.ladse.greasepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ladse.greasepay.booking.BookingListActivity;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.debitcard.CardDetailsActivity;
import com.ladse.greasepay.favorite.FavoritesFragment;
import com.ladse.greasepay.fragments.EditProfile;
import com.ladse.greasepay.fragments.FAQFragment;
import com.ladse.greasepay.fragments.PromocodeFragment;
import com.ladse.greasepay.fragments.SendFeedbackFragment;
import com.ladse.greasepay.home.HomePresenter;
import com.ladse.greasepay.home.HomePresenterImpl;
import com.ladse.greasepay.home.HomeView;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.utils.HomePagerAdapter;
import com.ladse.greasepay.login.LoginActivity;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, HomeView {
    Toolbar toolbar;
    TextView toolbarTitle;
    private FragmentManager fragmentManager;
    private DrawerLayout mDrawerLayout;
    private FragmentTransaction fragmentTransaction;
    private HomePresenter homePresenter;
    //private LinearLayout tabLayout;
    private ViewPager viewPager;
    private RelativeLayout tabBar;
    private ArrayList<RestaurantData> restaurantData;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        homePresenter = new HomePresenterImpl(this);
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        fragmentManager = getSupportFragmentManager();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawerLayout);

        final NavigationView drawer = (NavigationView) findViewById(R.id.activity_main_drawer);

        View headerView = drawer.getHeaderView(0);
        ImageView mDrawerProfilePic = (ImageView) headerView.findViewById(R.id.nav_drawer_profilePic);
        TextView mDrawerName = (TextView) headerView.findViewById(R.id.nav_drawer_profileName);
        mDrawerName.setText(AppSharedPreference.getUserName(MainActivity.this));
        //todo set name and profile pic in navigation header

        TextView mDrawerEditProfile = (TextView) headerView.findViewById(R.id.nav_drawer_editProfile);
        mDrawerEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Edit Profile";
                toolbarTitle.setText(title);
                EditProfile editProfile = new EditProfile();
                setFragment(editProfile, title);
            }
        });
        ImageButton menuBtn = (ImageButton) toolbar.findViewById(R.id.activity_main_button_menu);
        toolbarTitle = (TextView) toolbar.findViewById(R.id.activity_main_title);
        drawer.setNavigationItemSelectedListener(this);

        /*SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d");
        String label = "Location, " + sdf.format(new Date());
        drawer.setNavigationItemSelectedListener(this);
        toolbarTitle.setText(label);*/

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
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        tabBar = (RelativeLayout) findViewById(R.id.main_screen_tabLayout);
        tabBar.setVisibility(View.VISIBLE);
        viewPager = (ViewPager) findViewById(R.id.main_screen_viewPager);
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab_heading_bars));
        // tabLayout.addTab(tabLayout.newTab().setText(R.string.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_drawer_editProfile:
                tabBar.setVisibility(View.GONE);
                title = "Edit Profile";
                toolbarTitle.setText(title);
                EditProfile editProfile = new EditProfile();
                setFragment(editProfile, title);
                break;
            case R.id.nav_home:
                //tabBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.nav_my_grease_pay:
                // tabBar.setVisibility(View.GONE);
                title = "My Grease Pay";
                toolbarTitle.setText("My Grease Pay");
                Intent intent = new Intent(MainActivity.this, BookingListActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_favorite:
                tabBar.setVisibility(View.GONE);
                title = "Favorites";

                FavoritesFragment favoritesFragment = new FavoritesFragment();
                setFragment(favoritesFragment, title);
                break;
            case R.id.nav_promocode:
                tabBar.setVisibility(View.GONE);
                title = "Promocode";
                PromocodeFragment promocodeFragment = new PromocodeFragment();
                setFragment(promocodeFragment, title);
                break;
            case R.id.nav_payment:
                tabBar.setVisibility(View.GONE);
                title = "Payment";
                CardDetailsActivity cardDetailsActivity = new CardDetailsActivity();
                setFragment(cardDetailsActivity, title);
                //cardDetailsActivity.setArguments(bundle);
                break;
            case R.id.nav_send_feedback:
                tabBar.setVisibility(View.GONE);
                title = "Send Feedback";
                SendFeedbackFragment feedbackFragment = new SendFeedbackFragment();
                setFragment(feedbackFragment, title);
                break;
            case R.id.nav_invite:
                tabBar.setVisibility(View.GONE);
                toolbarTitle.setText("Invite");

                break;
            case R.id.nav_faq:
                tabBar.setVisibility(View.GONE);
                title = "FAQ";
                FAQFragment faqFragment = new FAQFragment();
                faqFragment.setContext(this);
                setFragment(faqFragment, title);
                break;
            case R.id.nav_settings:
                tabBar.setVisibility(View.GONE);
                break;
            case R.id.nav_signOut:
                logOut(AppSharedPreference.getAuthToken(this));
                break;

        }
        toolbarTitle.setText(title);
        return false;
    }

    private void setFragment(Fragment fragment, String title) {
        //tabLayout.setVisibility(View.GONE);
        String fragmentId = fragment.getClass().getCanonicalName();
        viewPager.setVisibility(View.GONE);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onHomeScreenResponseSuccess(ArrayList<RestaurantData> restaurantData) {
        AlertManager.disMissDialog();
        this.restaurantData = restaurantData;
        final HomePagerAdapter adapter = new HomePagerAdapter(fragmentManager, 1, restaurantData, homePresenter);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, true);

       /* viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }

    @Override
    public void onHomeScreenResponseError() {
        AlertManager.showErrorDialog(MainActivity.this, "Server not reachable");
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void logOut(String authToken) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.logoutFromApp(authToken);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                if (model.getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)) {
                    AppSharedPreference.setAuthToken(" ", MainActivity.this);
                    AppSharedPreference.setUsername(" ", MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                AlertManager.showErrorDialog(MainActivity.this, model.getMessage());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentManager.getBackStackEntryCount() > 0) {
                for(int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
                    fragmentManager.popBackStack();
                    toolbarTitle.setText("");
                    tabBar.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                }
            } else {

                super.onBackPressed();
            }


        }
    }

    public void removeCurrentFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment currentFrag = getSupportFragmentManager().findFragmentByTag(tag);


        String fragName = "NONE";

        if (currentFrag != null)
            fragName = currentFrag.getClass().getSimpleName();


        if (currentFrag != null)
            transaction.remove(currentFrag);

        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        homePresenter.getRestaurantData(MainActivity.this, new RestaurantRequest());
    }

    @Override
    protected void onResume() {
        super.onResume();
       // AlertManager.showProgressDialog(this);

    }
}
