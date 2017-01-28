package com.ladse.greasepay.promocode.checkpromocode.controler;

import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

/**
 * Created by pkatya on 1/28/17.
 */
public interface CheckPromoCodeView {
    void validatePromoCode(CheckPromoCodeRequest checkPromoCodeRequest);
    void onPromocodeValidate(CheckPromoCodeData data);
    void onPromocodeValidateError(String message);
    void onPromocodeValidateServerError();
}

