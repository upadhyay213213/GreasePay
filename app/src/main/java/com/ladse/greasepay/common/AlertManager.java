package com.ladse.greasepay.common;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.ladse.greasepay.R;

/**
 * Created by pkatya on 1/27/17.
 */
public class AlertManager {

    public static void showErrorDialog(Context context,String message){
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
}
