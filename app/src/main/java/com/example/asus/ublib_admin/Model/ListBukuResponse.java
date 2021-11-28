package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListBukuResponse {

    @SerializedName("success")
    @Expose
    private List<ListBukuResource> listBukuResources = null;

    public List<ListBukuResource> getSuccess() {
        return listBukuResources;
    }

    public void setSuccess(List<ListBukuResource> listBukuResources) {
        this.listBukuResources = listBukuResources;
    }
}
