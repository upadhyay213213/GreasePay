package com.ladse.greasepay.framework;

/**
 * Created by pkatya on 1/24/17.
 */
public class BasePresenter <T extends MVPView> implements Presenter <T> {
protected  T view;

    @Override
    public void attachView(T mvpView) {
        view=mvpView;

    }

    @Override
    public void detachView() {
view=null;
    }
}
