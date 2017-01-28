package com.ladse.greasepay.home.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ladse.greasepay.R;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.model.OutletModel;
import com.ladse.greasepay.home.utils.OutletFragmentAdapter;
import com.ladse.greasepay.home.utils.OutletListTouchListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreenFragmentBarsClubs extends Fragment {
    private RecyclerView outletList;
    private ArrayList<RestaurantData> restaurantDataArrayList;

    public HomeScreenFragmentBarsClubs() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_screen_fragment_bars_clubs, container, false);
        outletList = (RecyclerView) v.findViewById(R.id.home_fragment_bar_recyclerView);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            restaurantDataArrayList= (ArrayList<RestaurantData>) bundle.getSerializable(AppConstatnts.RESTAURANT_LIST);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        outletList.setHasFixedSize(true);

        ArrayList<RestaurantData> outletListFetch = restaurantDataArrayList;
        OutletFragmentAdapter adapter = new OutletFragmentAdapter(outletListFetch, new OutletFragmentAdapter.OutletListChangeListener() {
            @Override
            public void OnFavChangeListener(boolean isFav) {
                Toast.makeText(getContext(), "" + isFav, Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());

        outletList.setLayoutManager(layout);
        //outletList.setAdapter(adapter);
        outletList.addOnItemTouchListener(new OutletListTouchListener(getContext(), new OutletListTouchListener.OnOutletTouchListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private ArrayList<RestaurantData> getOutLetList() {
        ArrayList<RestaurantData> outletList = new ArrayList<>();
        OutletModel model = new OutletModel();
        model.setOutletName("Outlet 1");
        model.setOutletAddress();
        model.setIsFavorite(false);
        model.setOutletDistance(20);
        model.setOutletImageUrl("http://www.aiai.ed.ac.uk/project/coax/demo/2002/graphics/CoAX-Ship-Explosion-400x200.jpg");
        //outletList.add(model);

        model = new OutletModel();
        model.setOutletName("Outlet 2");
        model.setOutletAddress();
        model.setIsFavorite(true);
        model.setOutletDistance(30);
        model.setOutletImageUrl("http://gadgetultra.com/wp-content/uploads/2015/10/tomb-400x200.jpg");
       // outletList.add(model);

        model = new OutletModel();
        model.setOutletName("Outlet 2");
        model.setOutletAddress();
        model.setIsFavorite(false);
        model.setOutletDistance(40);
        model.setOutletImageUrl("http://shreefestival.com/wp-content/uploads/2014/07/CWG2014-400x200.jpg");
        //outletList.add(model);

        return outletList;
    }
}
