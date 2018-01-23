package com.thai_sanscript.thaisanscript.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class ToastUtil {

    private static ToastUtil instance;

    public static ToastUtil getInstance() {
        if (instance == null)
            instance = new ToastUtil();
        return instance;
    }

    private ToastUtil() {
    }

    public void toast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    public void toast(Context context, @StringRes int msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }

    public void toastLong(Context context, @StringRes int msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }

}
