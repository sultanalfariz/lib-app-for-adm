package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeminjamanResponse {

    @SerializedName("success")
    @Expose
    private List<PeminjamanResource> peminjamanResources = null;

    public List<PeminjamanResource> getSuccess() {
        return peminjamanResources;
    }

    public void setSuccess(List<PeminjamanResource> peminjamanResources) {
        this.peminjamanResources = peminjamanResources;
    }
}
