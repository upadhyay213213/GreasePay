package com.ladse.greasepay.framework;

/**
 * Created by pkatya on 1/24/17.
 */
public interface MVPView {
    void onSuccess(Model response);
    void onError(Model error);
    void onProgress();

}
