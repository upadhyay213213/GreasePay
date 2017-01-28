package com.ladse.greasepay.common;

import com.ladse.greasepay.constants.AppConstatnts;

/**
 * Created by pkatya on 1/28/17.
 */
public class Util {
    public static boolean isResponseSuccess(String succes){
        return succes.equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS);
    }
}
