package com.ladse.greasepay.sinup;

/**
 * Created by pkatya on 1/26/17.
 */
public interface SignUpPresenter {
    void validateSignUpDate(String fName,String lName,String phoneNo,String email,String password,boolean validateSignUpDate);
    void destroy();
}
