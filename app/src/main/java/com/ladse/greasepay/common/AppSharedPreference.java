package com.ladse.greasepay.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.ladse.greasepay.constants.AppConstatnts;

/**
 * Created by pkatya on 1/28/17.
 */
public class AppSharedPreference {
    static SharedPreferences sharedPreferences;

    public static void setAuthToken(String authToken, Context context){
        sharedPreferences=context.getSharedPreferences("pref",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AppConstatnts.AUTH_TOKEN, authToken);
        editor.commit();
    }

    public static String getAuthToken(Context context){
        sharedPreferences=context.getSharedPreferences("pref",Context.MODE_PRIVATE);
        return sharedPreferences.getString(AppConstatnts.AUTH_TOKEN,"");
    }

    public static void setUsername(String userName, Context context){
        sharedPreferences=context.getSharedPreferences("pref",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AppConstatnts.USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context context){
        sharedPreferences=context.getSharedPreferences("pref",Context.MODE_PRIVATE);
        return sharedPreferences.getString(AppConstatnts.USER_NAME,"");
    }
}
