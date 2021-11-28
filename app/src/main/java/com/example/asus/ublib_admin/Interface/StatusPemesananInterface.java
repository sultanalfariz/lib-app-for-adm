package com.example.asus.ublib_admin.Interface;

import com.example.asus.ublib_admin.Model.StatusPemesanan;
import com.example.asus.ublib_admin.Model.StatusPemesananResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StatusPemesananInterface {

    @POST("ubah_status_peminjaman/{id}")
    Call<StatusPemesananResponse> statusPemesanan(@Path("id") String id,
                                                  @Body StatusPemesanan statusPemesanan);
}
