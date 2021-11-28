package com.example.asus.ublib_admin.Interface;

import com.example.asus.ublib_admin.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login_admin")
    Call<LoginResponse> login(@Field("username") String username,
                              @Field("password") String password);
}
