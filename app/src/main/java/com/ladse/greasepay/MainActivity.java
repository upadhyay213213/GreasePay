package com.ladse.greasepay;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ladse.greasepay.fragments.FAQFragment;
import com.ladse.greasepay.fragments.FavoritesFragment;
import com.ladse.greasepay.fragments.MyGreasePayFragment;
import com.ladse.greasepay.fragments.PaymentFragment;
import com.ladse.greasepay.fragments.PromocodeFragment;
import com.ladse.greasepay.fragments.SendFeedbackFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    TextView toolbarTitle;
    private FragmentManager fragmentManager;
    private DrawerLayout mDrawerLayout;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fragmentManager = getSupportFragmentManager();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawerLayout);
        final NavigationView drawer = (NavigationView) findViewById(R.id.activity_main_drawer);
        ImageButton menuBtn = (ImageButton) toolbar.findViewById(R.id.activity_main_button_menu);
        toolbarTitle = (TextView) toolbar.findViewById(R.id.activity_main_title);
        drawer.setNavigationItemSelectedListener(this);

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
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_drawer_editProfile:
                break;
            case R.id.nav_home:
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

                break;
            case R.id.nav_faq:
                toolbarTitle.setText("FAQ");
                FAQFragment faqFragment = new FAQFragment();
                setFragment(faqFragment);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_signOut:
                break;

        }
        return false;
    }
    private void setFragment(Fragment fragment){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_fragment_frame, fragment);
            fragmentTransaction.addToBackStack("current");
            fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            if(!fragmentTransaction.isEmpty()){
                fragmentManager.popBackStack();
            }
            else{
                super.onBackPressed();
            }
        }

    }
}
