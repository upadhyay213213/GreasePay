package com.ladse.greasepay.login;

import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

/**
 * UI logic related to Login
 */
public interface LoginView {
    void setCredentialsError();
    void setLoginSuccessFull(LoginSinUpResponse loginSinUpResponse);
    void setLoginFail(String message);

}
