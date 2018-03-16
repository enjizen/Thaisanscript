package com.thai_sanscript.thaisanscript.manager.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("Transliteration/json")
    Call<List<String>> transliteration(@Field("src-txt") String srcTxt, @Field("lang") String lang);
}
