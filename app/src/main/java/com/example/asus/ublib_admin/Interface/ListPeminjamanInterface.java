package com.example.asus.ublib_admin.Interface;

import com.example.asus.ublib_admin.Model.PeminjamanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPeminjamanInterface {

    @GET("tampil_peminjaman_diproses_admin")
    Call<PeminjamanResponse> peminjaman();
}
