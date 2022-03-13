package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class ResponseAbsen {
    @SerializedName("data")
    private DataAbsen dataAbsen;

    @SerializedName("messages")
    private String messages;

    @SerializedName("status")
    private boolean status;
}
