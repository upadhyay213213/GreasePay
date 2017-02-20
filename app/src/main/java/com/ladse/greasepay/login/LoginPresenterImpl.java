package com.ladse.greasepay.login;

import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginFinishedListener {
    LoginView loginView;
    LoginIntractorImpl loginIntractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginIntractor = new LoginIntractorImpl();
    }

    @Override
    public void validateUserCredentialsToLogin(String userName, String password, boolean isSocial) {
        //if (sanitate.checkInput(userName, password)) {
        LoginRequest loginRequest = new LoginRequest(userName, password, isSocial);
        loginIntractor.login(loginRequest, this);
        //} else {
        loginView.setCredentialsError();
        //}
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }


    @Override
    public void onSuccess(LoginSinUpResponse loginSinUpResponse) {
        AppSharedPreference.setAuthToken(loginSinUpResponse.getData().getAuthToken(),(LoginActivity)loginView);
        AppSharedPreference.setUsername(loginSinUpResponse.getData().getLoggedUser(),(LoginActivity)loginView);
        loginView.setLoginSuccessFull(loginSinUpResponse);

    }

    @Override
    public void onError(LoginSinUpResponse loginSinUpResponse) {
        loginView.setLoginFail(loginSinUpResponse.getMessage());
    }

    @Override
    public void onServerError() {

    }

}
