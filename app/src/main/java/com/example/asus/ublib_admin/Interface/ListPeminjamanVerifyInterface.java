package com.example.asus.ublib_admin.Interface;

import com.example.asus.ublib_admin.Model.PeminjamanVerifyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPeminjamanVerifyInterface {

    @GET("tampil_peminjaman_berjalan_admin")
    Call<PeminjamanVerifyResponse> peminjamanVerify();
}
