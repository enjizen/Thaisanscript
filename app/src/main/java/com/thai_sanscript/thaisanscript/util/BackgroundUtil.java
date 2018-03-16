package com.thai_sanscript.thaisanscript.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.manager.Contextor;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class BackgroundUtil {

    private static BackgroundUtil instance;

    public static BackgroundUtil getInstance() {
        if (instance == null)
            instance = new BackgroundUtil();
        return instance;
    }

    private Context mContext;

    private BackgroundUtil() {
        mContext = Contextor.getInstance().getContext();
    }

    public void setViewBackground(Drawable drawable, TextView textView){
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackgroundDrawable(drawable);
        }
        else {
            textView.setBackground(drawable);
        }
    }


    public void setViewBackground(Drawable drawable, ToggleButton toggleButton){
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            toggleButton.setBackgroundDrawable(drawable);
        }
        else {
            toggleButton.setBackground(drawable);
        }
    }

}
