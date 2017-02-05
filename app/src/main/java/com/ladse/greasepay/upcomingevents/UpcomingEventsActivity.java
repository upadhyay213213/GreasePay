package com.ladse.greasepay.upcomingevents;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;

import java.util.ArrayList;

public class UpcomingEventsActivity extends Activity implements EventView {
private EventPresenter eventPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);
        eventPresenter=new EventPresenterImpl(this, this);
        ////getDataFromServer


    }

    @Override
    public void onUpcomingEventsSuccess(ArrayList<EventData> eventDataArrayList) {
        Log.v("Events",eventDataArrayList.toString());
    }

    @Override
    public void onUpcomingEventsError(String message) {

    }

    @Override
    public void onUpcomingEventServerError() {
        AlertManager.showErrorDialog(this,getString(R.string.server_error));
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventPresenter.getUpcomingEventsList(new EventRequest());
    }
}
