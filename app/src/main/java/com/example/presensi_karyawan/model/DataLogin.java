package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @SerializedName("id_user")
    private String id_user;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("nama")
    private String nama;

    @SerializedName("jabatan")
    private String jabatan;

    @SerializedName("tempat_tgl_lahir")
    private String tempat_tgl_lahir;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getTempat_tgl_lahir() {
        return tempat_tgl_lahir;
    }

    public void setTempat_tgl_lahir(String tempat_tgl_lahir) {
        this.tempat_tgl_lahir = tempat_tgl_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    @SerializedName("no_telp")
    private String no_telp;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
