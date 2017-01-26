package com.ladse.greasepay.framework;

public interface Presenter<V extends MVPView> {
    void attachView(V mvpView);

    void detachView();
}