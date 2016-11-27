package com.example.adelfo.miscontactos.restAPI;

/**
 * Created by Adelfo on 22/11/2016.
 */

public final class ConstantesRestApi {
    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;

    public static final String KEY_GET_RECENT_MEDIA_X_USER = "users/{user_id}/media/recent";
    public static final String KEY_SEARCH = "users/search";

    //https://api.instagram.com/v1/users/search
    public static final String URL_SEARCH_BY_USERNAME = ROOT_URL + KEY_SEARCH;

    //https://api.instagram.com/v1/users/{user_id}/media/recent
    public static final String URL_GET_RECENT_MEDIA_X_USER = ROOT_URL + KEY_GET_RECENT_MEDIA_X_USER;
}
