package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class DataLaporan {
    @SerializedName("id_laporan")
    private String id_laporan;

    @SerializedName("id_presensi")
    private String id_presensi;

    @SerializedName("uraian_pekerjaan")
    private String uraian_pekerjaan;

    @SerializedName("tgl_laporan")
    private String tgl_laporan;

    public String getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(String id_laporan) {
        this.id_laporan = id_laporan;
    }

    public String getId_presensi() {
        return id_presensi;
    }

    public void setId_presensi(String id_presensi) {
        this.id_presensi = id_presensi;
    }

    public String getUraian_pekerjaan() {
        return uraian_pekerjaan;
    }

    public void setUraian_pekerjaan(String uraian_pekerjaan) {
        this.uraian_pekerjaan = uraian_pekerjaan;
    }

    public String getTgl_laporan() {
        return tgl_laporan;
    }

    public void setTgl_laporan(String tgl_laporan) {
        this.tgl_laporan = tgl_laporan;
    }
}
