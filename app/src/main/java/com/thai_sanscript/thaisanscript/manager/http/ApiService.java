package com.thai_sanscript.thaisanscript.manager.http;



import com.thai_sanscript.thaisanscript.model.AmphurModel;
import com.thai_sanscript.thaisanscript.model.ProvinceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public interface ApiService {

    @GET("masterdata/province")
    Call<ProvinceModel> getProvince(@Query("lang") String lang);

    @GET("masterdata/amphur")
    Call<AmphurModel> getAmphur(@Query("lang") String lang, @Query("provinceId") int province_id);

}
