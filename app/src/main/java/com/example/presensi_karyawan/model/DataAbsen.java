package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class DataAbsen {

    @SerializedName("id_presensi")
    private String id_presensi;

    @SerializedName("id_user")
    private String id_user;

    @SerializedName("waktu_datang")
    private String waktu_datang;

    @SerializedName("waktu_pulang")
    private String waktu_pulang;

    @SerializedName("tgl_presensi")
    private String tgl_presensi;

    @SerializedName("keterangan")
    private String keterangan;

    public String getId_presensi() {
        return id_presensi;
    }

    public void setId_presensi(String id_presensi) {
        this.id_presensi = id_presensi;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getWaktu_datang() {
        return waktu_datang;
    }

    public void setWaktu_datang(String waktu_datang) {
        this.waktu_datang = waktu_datang;
    }

    public String getWaktu_pulang() {
        return waktu_pulang;
    }

    public void setWaktu_pulang(String waktu_pulang) {
        this.waktu_pulang = waktu_pulang;
    }

    public String getTgl_presensi() {
        return tgl_presensi;
    }

    public void setTgl_presensi(String tgl_presensi) {
        this.tgl_presensi = tgl_presensi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
