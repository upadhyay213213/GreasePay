package com.ladse.greasepay.promocode.checkpromocode.controler;

import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;

/**
 * Created by pkatya on 1/28/17.
 */
public interface CheckPromoCodeView {
    void onPromocodeValidate(CheckPromoCodeData data);
    void onPromocodeValidateError(String message);
    void onPromocodeValidateServerError();
}

