package com.ladse.greasepay.home.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.home.model.RestaurantData;

import java.util.ArrayList;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class OutletFragmentAdapter extends RecyclerView.Adapter<BarViewHolder> {
    private ArrayList<RestaurantData> oModel;
    private Context context;
    private OutletListChangeListener cListener;
    private int position;
    private BarViewHolder holder;
    private String fvtAction;

    public OutletFragmentAdapter(ArrayList<RestaurantData> oModel) {
        this.oModel = oModel;
       // this.cListener = cListener;
    }

    @Override
    public BarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_outlet, parent, false);
        return new BarViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(BarViewHolder holder, final int position) {
        this.position=position;
        this.holder=holder;

        holder.bindData(oModel.get(position));


    }


    @Override
    public int getItemCount() {
        return oModel.size();
    }

    public interface OutletListChangeListener {
        void OnFavChange(boolean isFav);
    }



}
















