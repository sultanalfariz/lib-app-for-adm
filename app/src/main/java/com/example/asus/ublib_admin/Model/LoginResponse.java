package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("success")
    @Expose
    private LoginResource loginResource;

    public LoginResource getSuccess() {
        return loginResource;
    }

    public void setSuccess(LoginResource loginResource) {
        this.loginResource = loginResource;
    }
}
