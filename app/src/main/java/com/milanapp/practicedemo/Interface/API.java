package com.milanapp.practicedemo.Interface;

import com.milanapp.practicedemo.Model.Marvel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")

    Call<List<Marvel>> getmarvel();

}
