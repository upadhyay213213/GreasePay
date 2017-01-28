package com.ladse.greasepay.common;

/**
 * Created by pkatya on 1/28/17.
 */
public interface MVPView {
    void onSuccess(Object objects);
    Void onError(String message);
    Void onServerError();
}
