package com.ladse.greasepay.promocode.checkpromocode.controler;

import android.content.Context;

import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

/**
 * Created by pkatya on 1/28/17.
 */
public interface CheckPromoCodePresenter {
    void checkPromocodevalidation(Context context,CheckPromoCodeRequest checkPromoCodeRequest);
    void onPromocodeValidation(CheckPromoCodeData codeResponse);
}
