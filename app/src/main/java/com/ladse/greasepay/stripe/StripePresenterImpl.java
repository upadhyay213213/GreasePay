package com.ladse.greasepay.stripe;

/**
 * Created by Shrivats on 2/5/2017.
 */

public class StripePresenterImpl implements StripePresenter, StripeInteractor.StripeFinishedListener {

    private StripeView view;
    private StripeInteractorImpl stripeInteractor;

    public StripePresenterImpl(StripeView view) {
        this.view = view;
        stripeInteractor = new StripeInteractorImpl();
    }

    @Override
    public void onSuccess(StripeResponse stripeResponse) {
        view.setTokenSendSuccessful(stripeResponse);
    }

    @Override
    public void onError(StripeResponse stripeResponse) {
        view.setTokenSendFail(stripeResponse.getMessage());
    }

    @Override
    public void onServerError() {

    }

    @Override
    public void sendStripeToken(String stripeToken, String card_last_digit) {
        StripeRequest stripeRequest = new StripeRequest();
        stripeRequest.setStripe_token(stripeToken);
        stripeRequest.setCard_last_digit(card_last_digit);
        stripeInteractor.sendToken(stripeRequest, this);
    }
}
