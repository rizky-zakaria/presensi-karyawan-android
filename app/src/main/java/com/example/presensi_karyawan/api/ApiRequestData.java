package com.example.presensi_karyawan.api;

import com.example.presensi_karyawan.model.ResponseAbsen;
import com.example.presensi_karyawan.model.ResponseLaporan;
import com.example.presensi_karyawan.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestData {
    @FormUrlEncoded
    @POST("Auth")
    Call<ResponseLogin> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("Presensi")
    Call<ResponseAbsen> presensi(
            @Field("id_user") String id_user,
            @Field("flag") String flag
    );

    @FormUrlEncoded
    @POST("Laporan")
    Call<ResponseLaporan> laporan(
            @Field("laporan") String laporan,
            @Field("id_user") String id_user
    );
}
