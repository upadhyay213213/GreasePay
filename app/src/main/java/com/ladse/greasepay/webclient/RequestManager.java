package com.ladse.greasepay.webclient;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ladse.greasepay.appmanager.AppController;
import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.model.BookingDetailModel;
import com.ladse.greasepay.sinup.model.SignUpRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RequestManager {

    public static RequestManager mRequestManager;
    public RequestResponseInterface responseInterface;
    private String TAG = "requesttag";

    private RequestManager() {


    }

    public static RequestManager getInstance() {
        if(mRequestManager==null){
            mRequestManager=new RequestManager();
        }
        return mRequestManager;
    }


    public void LoginRequest(String userid, String password) {
        try {
            /**URL */
            String url = UrlConstants.LOGIN_API;

            JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", userid);
                jsonObject.put("password", password);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, jsonObject,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }
    }

    public void SinUp(SignUpRequest loginRequest) {
        try {
            /**URL */
            String url = UrlConstants.SIGN_UP_API ;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first_name", loginRequest.getFirstName());
            jsonObject.put("last_name", loginRequest.getLastName());
            jsonObject.put("username",loginRequest.getEmail());
            jsonObject.put("password",loginRequest.getPassword());
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, jsonObject,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }
    }

    public void forgotPassword(String userName) {
        try {
            /**URL */
            String url = UrlConstants.FORGOT_PASSWORD ;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", userName);

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, jsonObject,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }
    }


    public void logout(String authCode) {
        try {
            /**URL */
            String url = UrlConstants.LOGOUT;

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }


    }


    public void restraintBarSearch(Double lat, final Double lng) {
        try {
            /**URL */
            String url = UrlConstants.RESTAURANT_SEARCH;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("latitude", lat);
            jsonObject.put("longitude",lng);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }
    }


    public void upComingEvents(String lat, String lng) {
        try {
            /**URL */
            String url = UrlConstants.UPCOMING_EVENTS;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("latitude", lat);
            jsonObject.put("longitude",lng);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }

    }

    public void promoCode(String barID, String promoCode) {
        try {
            /**URL */
            String url = UrlConstants.CHECK_PROMO_CODE;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("bar_id", barID);
            jsonObject.put("promo_code",promoCode);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }

    }
    public void bookingList(String authCode) {
        try {
            /**URL */
            String url = UrlConstants.LIST_OF_BOOKINGS;

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }
    }

    public void setAsFav(String barID, String action) {
        try {
            /**URL */
            String url = UrlConstants.SET_FAVOURITE;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("bar_id", barID);
            jsonObject.put("action",action);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }

    }
    public void getFavourite(String authCode) {
        try {
            /**URL */
            String url = UrlConstants.GET_FAVOURITE;

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }


    }

    public void bookHotelAndBar(BookingDetailModel bookingDetailModel) {
        try {
            /**URL */
            String url = UrlConstants.BOOK_HOTEL_BAR;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stripe_token", "");
            jsonObject.put("bar_id","");
            jsonObject.put("male_person_per_fees", "");
            jsonObject.put("female_person_per_fees","");
            jsonObject.put("stripe_token", "");
            jsonObject.put("order_date","");
            jsonObject.put("male_entry_free", "");
            jsonObject.put("female_entry_free","");
            jsonObject.put("stripe_token", "");
            jsonObject.put("number_of_men","");
            jsonObject.put("number_of_women", "");
            jsonObject.put("price_for_men","");
            jsonObject.put("price_for_women", "");
            jsonObject.put("tax_fees","");
            jsonObject.put("total", "");
            jsonObject.put("advance_booking_fees","");

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            responseInterface.responseListener(response);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseInterface.errorListener(error);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "token");
                    return params;
                }
            };
            AppController.getInstance().getRequestQueue().add(jsonObjReq);

        } catch (Exception e) {
            System.out.println("requestexecption" + e.getMessage());
        }

    }
}
