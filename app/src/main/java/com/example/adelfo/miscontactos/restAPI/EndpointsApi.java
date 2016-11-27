package com.example.adelfo.miscontactos.restAPI;

import android.util.Log;

import com.example.adelfo.miscontactos.restAPI.Model.ContactoResponse;
import com.example.adelfo.miscontactos.restAPI.Model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Adelfo on 22/11/2016.
 */

public interface EndpointsApi {
    //https://api.instagram.com/v1/users/search?q=liz_salazar_s&access_token=4179481767.6a67fa6.ca3f237670924e89b088d8a088a08216
    @GET(ConstantesRestApi.URL_SEARCH_BY_USERNAME)
    Call<UsuarioResponse> getUser(@Query("q") String q, @Query("access_token") String access_token);

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_X_USER)
    Call<ContactoResponse> getRecentMedia(@Path("user_id") String user_id, @Query("access_token") String access_token);
}
