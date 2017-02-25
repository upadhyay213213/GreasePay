package com.ladse.greasepay.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.ladse.greasepay.R;

/**
 * Created by Shrivats on 1/27/17.
 */
public class AlertManager {

    private static ProgressDialog progressDialog;

    public static void showErrorDialog(Context context, String message){
        new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public static void showProgressDialog(Context context){
       progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("Please Wait");
        progressDialog.setTitle(context.getString(R.string.app_name));
        progressDialog.show();
    }

    public static void disMissDialog(){
        if(progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.dismiss();
        }

    }
}
