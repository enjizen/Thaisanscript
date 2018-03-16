package com.thai_sanscript.thaisanscript.manager.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public class HttpManager {

    private static final String baseUrl = "http://www.thai-sanscript.com/index.php/";
    private static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";

    private static HttpManager instance;
    private ApiService service;

    public static HttpManager getInstance(){
        if(instance == null)
            instance = new HttpManager();

        return  instance;
    }

    private HttpManager(){
        Gson gson = new GsonBuilder()
                        .setDateFormat(dateFormat)
                        .create();

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .client(NetworkClient.getInstance().unsafeOkHttpClient())
                                .build();

        service = retrofit.create(ApiService.class);
    }

    public ApiService getService(){
        return service;
    }
}
