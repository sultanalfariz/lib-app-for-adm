package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailResource {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("pengarang")
    @Expose
    private String pengarang;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("admin_id")
    @Expose
    private Integer adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
