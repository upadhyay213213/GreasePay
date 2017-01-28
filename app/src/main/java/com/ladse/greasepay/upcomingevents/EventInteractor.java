package com.ladse.greasepay.upcomingevents;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public interface EventInteractor {
    interface OnEventResponseReceived{
        void onEventResponseSuccess(ArrayList<EventData>eventDataArrayList);
        void onEventResponseError(String message);
        void onEventResponseServerError();
    }
    void getUpcomingEvents(String header,EventRequest eventRequest,OnEventResponseReceived onEventResponseReceived);
}
