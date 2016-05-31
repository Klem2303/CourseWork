package com.awesomedevelop.recyclerview;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RESTPK {
    @POST("/rreq.php")
    Call<JsonStr> loadJsonStr();

    @POST("/derf.php")
    Call<JsonStr> reloadJsonStr();

    @POST("/rewq.php")
    Call<Update> uploadJsonStr();
}
