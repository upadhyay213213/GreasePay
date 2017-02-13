package com.ladse.greasepay.promocode.checkpromocode.controler;

import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

/**
 * Created by pkatya on 1/28/17.
 */
public interface CheckPromoCodeInteracter {

    void validateFromoCode(String authToken,CheckPromoCodeRequest checkPromoCodeRequest,onValidatePromoCode onValidatePromoCode);
    interface onValidatePromoCode{
        void onValidatePromoCodeResponseReceived(CheckPromoCodeData data);
        void onValidatePromoCodeErrorReceived(String message);
        void onValidatePromoCodeServerError();

    }

}
