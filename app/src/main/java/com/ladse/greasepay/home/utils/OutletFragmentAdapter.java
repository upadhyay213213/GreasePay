package com.ladse.greasepay.home.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ladse.greasepay.R;
import com.ladse.greasepay.home.model.RestaurantData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class OutletFragmentAdapter extends RecyclerView.Adapter<OutletFragmentAdapter.ViewHolder> {
    private ArrayList<RestaurantData> oModel;
    private Context context;
    private OutletListChangeListener cListener;

    public OutletFragmentAdapter(ArrayList<RestaurantData> oModel, OutletListChangeListener cListener) {
        this.oModel = oModel;
        this.cListener = cListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_outlet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.outletName.setText(oModel.get(position).getName());
        holder.outletAddress.setText(oModel.get(position).getAddress());
        holder.outletDistance.setText((oModel.get(position).getDistance()) + "\n miles");
        Picasso.with(context).load(oModel.get(position).getImageUrl()).into(holder.outletImage);
        ToggleButton mFavBtn = holder.isFavorite;
        mFavBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cListener.OnFavChangeListener(true);
                } else {
                    cListener.OnFavChangeListener(false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return oModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView outletImage;
        private TextView outletName;
        private TextView outletAddress;
        private TextView outletDistance;
        private ToggleButton isFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            outletImage = (ImageView) itemView.findViewById(R.id.home_fragment_outlet_outletImage);
            outletName = (TextView) itemView.findViewById(R.id.home_fragment_outlet_outletName);
            outletAddress = (TextView) itemView.findViewById(R.id.home_fragment_outlet_outletAddress);
            outletDistance = (TextView) itemView.findViewById(R.id.home_fragment_outlet_outletDistance);
            isFavorite = (ToggleButton) itemView.findViewById(R.id.home_fragment_outlet_button_fav);
        }
    }

    public interface OutletListChangeListener {
        void OnFavChangeListener(boolean isFav);
    }
}
