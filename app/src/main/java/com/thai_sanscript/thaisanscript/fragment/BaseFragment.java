package com.thai_sanscript.thaisanscript.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.thai_sanscript.thaisanscript.manager.http.CallApiServiceManager;
import com.thai_sanscript.thaisanscript.manager.http.CallApiServiceManagerListener;
import com.thai_sanscript.thaisanscript.util.LogUtil;

import java.util.List;

/**
 * Created by Wanchalerm Yuphasuk on 27/12/2017 AD.
 */

public class BaseFragment extends Fragment implements CallApiServiceManagerListener {



    private CallApiServiceManager apiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = new CallApiServiceManager(this);
    }

    public CallApiServiceManager getApiService() {
        return apiService;
    }


    @Override
    public void translateResponse(List<String> resultList) {
        LogUtil.getInstance().i("BaseFragment","kldfsofw");
        LogUtil.getInstance().i("BaseFragment", "Result = " + new Gson().toJson(resultList));
    }



    /**
     *
     * Api Service Response
     *
     */


}
