package com.example.asus.ublib_admin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusPemesananResource {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nim")
    @Expose
    private String nim;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("pengarang")
    @Expose
    private String pengarang;
    @SerializedName("tgl_peminjaman")
    @Expose
    private String tglPeminjaman;
    @SerializedName("tgl_pengembalian")
    @Expose
    private String tglPengembalian;
    @SerializedName("status_peminjaman")
    @Expose
    private String statusPeminjaman;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("admin_id")
    @Expose
    private Integer adminId;
    @SerializedName("buku_id")
    @Expose
    private Integer bukuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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

    public String getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(String tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public String getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(String tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getBukuId() {
        return bukuId;
    }

    public void setBukuId(Integer bukuId) {
        this.bukuId = bukuId;
    }

}
