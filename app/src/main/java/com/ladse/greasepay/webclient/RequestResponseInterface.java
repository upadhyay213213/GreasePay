package com.ladse.greasepay.webclient;

import com.android.volley.VolleyError;

/**
 * Created by nupadhay on 10/15/2015.
 */
public interface RequestResponseInterface {

    public void responseListener(Object o);

    public void errorListener(VolleyError error);
}