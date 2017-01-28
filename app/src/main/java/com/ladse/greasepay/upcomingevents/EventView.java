package com.ladse.greasepay.upcomingevents;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public interface EventView {

    void onUpcomingEventsSuccess(ArrayList<EventData>eventDataArrayList);
    void onUpcomingEventsError(String message);
    void onUpcomingEventServerError();


}
