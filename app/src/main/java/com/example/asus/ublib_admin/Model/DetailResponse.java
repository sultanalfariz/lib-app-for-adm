package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailResponse {

    @SerializedName("success")
    @Expose
    private List<DetailResource> detailResources = null;

    public List<DetailResource> getSuccess() {
        return detailResources;
    }

    public void setSuccess(List<DetailResource> detailResources) {
        this.detailResources = detailResources;
    }
}
