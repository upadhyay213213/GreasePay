package com.ladse.greasepay.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.booking.BookingData;

import java.util.ArrayList;

/**
 * Created by Shrivats on 2/11/2017.
 */

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {
    private ArrayList<BookingData> bookingData;
    private OnRedeemClickListener listener;

    public BookingListAdapter(ArrayList<BookingData> bookingData, OnRedeemClickListener listener) {
        this.bookingData = bookingData;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mygreasepay_adapter_view, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mName.setText(bookingData.get(position).getRestaurantName());
        holder.mIssueDate.setText(bookingData.get(position).getOrderDate());
        holder.mExpiryDate.setText(bookingData.get(position).getRedemptionDate());
        holder.mNoOfMen.setText(bookingData.get(position).getNumberOfMen());
        holder.mNoOfWomen.setText(bookingData.get(position).getNumberOfWomen());
        boolean isRedeemable = bookingData.get(position).getStatus().equals("Complete") ? false : true;
        holder.mRedeem.setActivated(isRedeemable);
    }

    @Override
    public int getItemCount() {
        return bookingData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mName, mIssueDate, mExpiryDate, mNoOfMen, mNoOfWomen;
        private Button mRedeem;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.mygreasepay_adapter_name);
            mIssueDate = (TextView) itemView.findViewById(R.id.greasepay_adapter_input_issuedDate);
            mExpiryDate = (TextView) itemView.findViewById(R.id.greasepay_adapter_input_expiresDate);
            mNoOfMen = (TextView) itemView.findViewById(R.id.greasepay_adapter_input_male);
            mNoOfWomen = (TextView) itemView.findViewById(R.id.greasepay_adapter_input_female);
            mRedeem = (Button) itemView.findViewById(R.id.greasepay_adapter_button_redeem);
            mRedeem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.greasepay_adapter_button_redeem) {
                listener.OnRedeemClick(getAdapterPosition());
            }
        }
    }

    public interface OnRedeemClickListener {
        void OnRedeemClick(int position);
    }
}
