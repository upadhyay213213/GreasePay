package com.ladse.greasepay.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.model.EventModel;
import com.ladse.greasepay.upcomingevents.EventData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Shrivats on 1/29/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<EventData> eventList;
    private Context context;

    public EventAdapter(ArrayList<EventData> eventList) {
        this.eventList = eventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //todo Initialize and set event details
        holder.mEventName.setText(eventList.get(position).getEventName());
        holder.mEventDate.setText(eventList.get(position).getStartDateTime());
        Picasso.with(context).load(eventList.get(position).getImageUrl()).into(holder.mEventImage);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mEventImage;
        private TextView mEventName, mEventDate;

        public ViewHolder(View itemView) {
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.event_list_eventImage);
            mEventName = (TextView) itemView.findViewById(R.id.event_list_eventName);
            mEventDate = (TextView) itemView.findViewById(R.id.event_list_eventDate);
        }
    }
}
