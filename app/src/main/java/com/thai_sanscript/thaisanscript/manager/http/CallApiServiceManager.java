package com.thai_sanscript.thaisanscript.manager.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.thai_sanscript.thaisanscript.R;
import com.thai_sanscript.thaisanscript.manager.Contextor;
import com.thai_sanscript.thaisanscript.util.LogUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Wanchalerm Yuphasuk on 17/1/2018 AD.
 */

public class CallApiServiceManager {

    /**
     * Context Activity
     */
    private final Context context;

    /**
     * Listener return result
     */
    private final CallApiServiceManagerListener mListener;

    /**
     * Call Api Service
     */
    private final ApiService apiService;


    /**
     * @param listener
     */
    public CallApiServiceManager(CallApiServiceManagerListener listener){
        this.context = Contextor.getInstance().getContext();
        this.mListener = listener;
        this.apiService = HttpManager.getInstance().getService();
    }

    public void getProvince(String scrTxt, String lang){
         LogUtil.getInstance().i("dddd","dddddd");
        apiService.transliteration(scrTxt,lang).enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                LogUtil.getInstance().i("CallApi",String.valueOf(response.isSuccessful()));
                if(response.isSuccessful()){
                    mListener.translateResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }



}
