package com.ladse.greasepay.webclient_retro;

import com.ladse.greasepay.constants.UrlConstants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {
    private static Retrofit retrofit;
    private static Retrofit.Builder restBuilder;
    private static Retrofit.Builder soapBuilder;
    private static ServerCall serverCall;

    // No need to instantiate this class.
    private ServiceGenerator() {

    }

    private static ServerCall getRestService() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        restBuilder = new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = restBuilder.build();
        serverCall=retrofit.create(ServerCall.class);
        return serverCall;
    }
    public static ServerCall getRestWebService(){

        return getRestService();

    }


}
