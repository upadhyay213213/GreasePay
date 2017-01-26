package com.ladse.greasepay.sinup;


import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

public interface SinUpView {
    void setValidationError();
    void onSinUpSuccessFull(LoginSinUpResponse loginSinUpResponse);
    void onSinUpError(LoginSinUpResponse loginSinUpResponse);

}
