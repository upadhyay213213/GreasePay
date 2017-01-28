package com.ladse.greasepay.upcomingevents;

import com.ladse.greasepay.common.AppSharedPreference;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventPresenterImpl implements EventPresenter, EventInteractor.OnEventResponseReceived {
    private EventView eventView;
    private EventInteractor eventInteractor;

    public EventPresenterImpl(EventView eventView) {
        this.eventView = eventView;
        eventInteractor = new EventInteractorImpl();
    }

    @Override
    public void getUpcomingEventsList(EventRequest eventRequest) {
        eventInteractor.getUpcomingEvents(AppSharedPreference.getAuthToken((UpcomingEventsActivity) eventView), eventRequest, this);
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
