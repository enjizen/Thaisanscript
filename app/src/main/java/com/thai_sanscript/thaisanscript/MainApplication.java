package com.thai_sanscript.thaisanscript;

import android.app.Application;

import com.thai_sanscript.thaisanscript.manager.Contextor;


/**
 * Created by Wanchalerm Yuphasuk on 22/1/2018 AD.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
