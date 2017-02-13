package com.ladse.greasepay.promocode.checkpromocode.controler;

import android.content.Context;

import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

/**
 * Created by pkatya on 1/28/17.
 */
public class CheckPromoCodePresenterImpl implements CheckPromoCodePresenter, CheckPromoCodeInteracterImpl.onValidatePromoCode {
    private CheckPromoCodeInteracter checkPromoCodeInteracter;
    private CheckPromoCodeView checkPromoCodeView;

    public CheckPromoCodePresenterImpl(CheckPromoCodeView checkPromoCodeView) {
        this.checkPromoCodeView = checkPromoCodeView;
        checkPromoCodeInteracter = new CheckPromoCodeInteracterImpl();
    }

    @Override
    public void checkPromocodevalidation(Context context, CheckPromoCodeRequest checkPromoCodeRequest) {
        checkPromoCodeInteracter.validateFromoCode(AppSharedPreference.getAuthToken(context), checkPromoCodeRequest, this);//// TODO: 1/28/17 cast to activity


    }

    @Override
    public void onPromocodeValidation(CheckPromoCodeData codeResponse) {
        checkPromoCodeView.onPromocodeValidate(codeResponse);
    }


    @Override
    public void onValidatePromoCodeResponseReceived(CheckPromoCodeData data) {
        checkPromoCodeView.onPromocodeValidate(data);
    }

    @Override
    public void onValidatePromoCodeErrorReceived(String message) {
        checkPromoCodeView.onPromocodeValidateError(message);

    }

    @Override
    public void onValidatePromoCodeServerError() {
        checkPromoCodeView.onPromocodeValidateServerError();
    }
}
