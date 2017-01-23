package com.ladse.greasepay.common;

import android.util.Patterns;

/**
 * Created by Shrivats on 1/23/2017.
 */

public class InputSanitation {

    private String ERROR_MSG = "";

    public boolean checkInput(String un, String pass) {

        if (un.equals("")) {
            setError(0);
            return false;
        } else if (pass.equals("")) {
            setError(0);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(un).matches()) {
            setError(2);
            return false;
        } else if (pass.length() < 8) {
            setError(1);
            return false;
        }
        return true;
    }

    private void setError(int error_code) {
        switch (error_code) {
            case 0:
                ERROR_MSG = "Field can't be empty";
                break;
            case 1:
                ERROR_MSG = "Password should be 8 characters";
                break;
            case 2:
                ERROR_MSG = "Invalid email";
                break;
        }
    }

    public String getError() {
        return ERROR_MSG;
    }
}
