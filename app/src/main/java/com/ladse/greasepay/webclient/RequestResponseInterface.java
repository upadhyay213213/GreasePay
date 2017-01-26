package com.ladse.greasepay.webclient;

import com.android.volley.VolleyError;

public interface RequestResponseInterface {

    public void responseListener(Object o);

    public void errorListener(VolleyError error);
}