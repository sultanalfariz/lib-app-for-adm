package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeminjamanVerifyResponse {

    @SerializedName("success")
    @Expose
    private List<PeminjamanVerifyResource> peminjamanVerifyResources = null;

    public List<PeminjamanVerifyResource> getSuccess() {
        return peminjamanVerifyResources;
    }

    public void setSuccess(List<PeminjamanVerifyResource> peminjamanVerifyResources) {
        this.peminjamanVerifyResources = peminjamanVerifyResources;
    }
}
