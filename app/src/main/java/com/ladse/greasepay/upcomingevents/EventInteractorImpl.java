package com.ladse.greasepay.upcomingevents;

import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventInteractorImpl implements EventInteractor {

    @Override
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getUpcomingEvents(String authToken, EventRequest eventRequest, final OnEventResponseReceived onEventResponseReceived) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<EventResponse> si = retrofitInterface.getUpComingEventsData(authToken, eventRequest);
        si.enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                EventResponse eventResponse = response.body();
                if (eventResponse.getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)) {
                    onEventResponseReceived.onEventResponseSuccess(eventResponse.getData());

                } else {
                    onEventResponseReceived.onEventResponseError(eventResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {

                onEventResponseReceived.onEventResponseServerError();
            }
        });

    }
}