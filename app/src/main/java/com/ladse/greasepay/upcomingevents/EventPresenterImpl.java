package com.ladse.greasepay.upcomingevents;

import android.content.Context;

import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.restaurantdetails.OutletDetailsFragmentEvents;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventPresenterImpl implements EventPresenter, EventInteractor.OnEventResponseReceived {
    private EventView eventView;
    private EventInteractor eventInteractor;
    private Context context;

    public EventPresenterImpl(EventView eventView, Context context) {
        this.eventView = eventView;
        eventInteractor = new EventInteractorImpl();
        this.context = context;
    }

    @Override
    public void getUpcomingEventsList(EventRequest eventRequest) {
        eventInteractor.getUpcomingEvents(AppSharedPreference.getAuthToken(context), eventRequest, this);
    }

    @Override
    public void onEventResponseSuccess(ArrayList<EventData> eventDataArrayList) {
        eventView.onUpcomingEventsSuccess(eventDataArrayList);
    }

    @Override
    public void onEventResponseError(String message) {
        eventView.onUpcomingEventsError(message);
    }

    @Override
    public void onEventResponseServerError() {
        eventView.onUpcomingEventServerError();
    }
}
