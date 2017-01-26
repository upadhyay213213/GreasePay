package com.ladse.greasepay.login;

/**
 * Business Login related to login
 */
public interface LoginPresenter {
    void validateUserCredentialsToLogin(String userName,String password,boolean isSocial);
    void onDestroy();

}
