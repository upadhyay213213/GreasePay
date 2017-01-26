package com.ladse.greasepay.sinup;

import com.ladse.greasepay.common.InputSanitation;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;


public class SinUpPresenterImpl implements SignUpPresenter,SignUpInteractor.OnSinUpResponseListener {
    private SinUpView sinUpView;
    private SinUpInteractorImpl sinUpInteractor;

    public SinUpPresenterImpl(SinUpView sinUpView) {
        this.sinUpView = sinUpView;
        sinUpInteractor=new SinUpInteractorImpl();
    }


    @Override
    public void validateSignUpDate(String fName, String lName, String phoneNo, String email, String password,boolean isSocial) {
        if(InputSanitation.chekSignupInput(fName,lName,phoneNo,email,password)){
            sinUpInteractor.sinup(new SignUpRequest(fName,lName,email,phoneNo,password,isSocial),this);
        }

    }

    @Override
    public void destroy() {
        sinUpView=null;

    }

    @Override
    public void onSuccess(LoginSinUpResponse loginSinUpResponse) {
        sinUpView.onSinUpSuccessFull(loginSinUpResponse);
    }

    @Override
    public void onError(LoginSinUpResponse loginSinUpResponse) {

    }

    @Override
    public void onServerError() {
        sinUpView.setValidationError();

    }
}
