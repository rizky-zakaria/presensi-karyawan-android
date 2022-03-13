package com.example.presensi_karyawan.model;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("data")
    private DataLogin dataLogin;

    @SerializedName("messages")
    private String messages;

    @SerializedName("status")
    private boolean status;

    public DataLogin getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
