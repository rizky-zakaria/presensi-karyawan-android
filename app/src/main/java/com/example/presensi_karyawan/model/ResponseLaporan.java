package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class ResponseLaporan {

    @SerializedName("data")
    private DataLaporan dataLaporan;

    @SerializedName("messages")
    private String messages;

    @SerializedName("status")
    private boolean status;

}
