package com.example.asus.ublib_admin.Interface;

import com.example.asus.ublib_admin.Model.StatusBuku;
import com.example.asus.ublib_admin.Model.StatusBukuResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StatusBukuInterface {

    @POST("ubah_status_buku/{id}")
    Call<StatusBukuResponse> statusBuku(@Path("id") String id,
                                             @Body StatusBuku statusBuku);
}
