package com.ladse.greasepay.restaurantdetails;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.model.EventModel;
import com.ladse.greasepay.upcomingevents.EventData;
import com.ladse.greasepay.upcomingevents.EventPresenter;
import com.ladse.greasepay.upcomingevents.EventPresenterImpl;
import com.ladse.greasepay.upcomingevents.EventRequest;
import com.ladse.greasepay.upcomingevents.EventView;
import com.ladse.greasepay.utils.EventAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutletDetailsFragmentEvents extends Fragment implements EventView{

    private RecyclerView eventList;
    private TextView mLabelDate, mDetailBoxName, mDetailBoxDate, mDetailBoxAddress, mDetailBoxCost;
    EventPresenter eventPresenter;
    ImageView mCalIcon;
    private ArrayList<EventData> eventDetailsList;
    private TextView labelMessage;
    public OutletDetailsFragmentEvents() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.outlet_details_tab_upcomingevents, container, false);

        eventList = (RecyclerView) v.findViewById(R.id.outlet_details_fragment_events_recyclerEvent);
        mLabelDate = (TextView) v.findViewById(R.id.outlet_details_fragment_events_label_date);
        mCalIcon = (ImageView) v.findViewById(R.id.outlet_details_fragment_events_icon_cal);
        eventDetailsList = new ArrayList<>();
        mDetailBoxName = (TextView) v.findViewById(R.id.outlet_details_fragment_events_detailBox_eventName);
        mDetailBoxDate = (TextView) v.findViewById(R.id.outlet_details_fragment_events_detailBox_eventDate);
        mDetailBoxCost = (TextView) v.findViewById(R.id.outlet_details_fragment_events_detailBox_eventCost);
        mDetailBoxAddress = (TextView) v.findViewById(R.id.outlet_details_fragment_events_detailBox_eventAddress);
        labelMessage = (TextView) v.findViewById(R.id.outlet_details_fragment_events_label_message);
        eventPresenter = new EventPresenterImpl(this, getActivity());
        return v;
    }

    @Override
    public void onStart()
    {
        eventPresenter.getUpcomingEventsList(new EventRequest());
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onUpcomingEventsSuccess(ArrayList<EventData> eventDataArrayList) {
            eventDetailsList = eventDataArrayList;
            setDetails();
    }

    @Override
    public void onUpcomingEventsError(String message) {

    }

    @Override
    public void onUpcomingEventServerError() {

    }
    private void setDetails(){
        EventAdapter eveAd = new EventAdapter(eventDetailsList);
        RecyclerView.LayoutManager lMan = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        eventList.setLayoutManager(lMan);
        eventList.setAdapter(eveAd);
        //labelMessage.setText("success");

    }
}
